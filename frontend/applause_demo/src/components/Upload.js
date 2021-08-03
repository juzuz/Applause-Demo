import React, { useState} from 'react'
import {Form, Button} from 'react-bootstrap'
import '../css/uploadForm.css';
import {uploadFile} from "../services/FileService";
import { toast } from 'react-toastify';
import ReactLoading from 'react-loading';
import reportWebVitals from "../reportWebVitals";
function Upload() {

    const [loading,setLoading] = useState(false);

    const handleSubmit=(e) => {
        e.preventDefault();

        let files = {
            tester: e.target.tester.files[0],
            devices: e.target.devices.files[0],
            test_device: e.target.test_device.files[0],
            bugs: e.target.bugs.files[0]
        };

        if(files.tester === undefined && files.devices === undefined
            && files.test_device === undefined && files.bugs === undefined){
            toast.error("At least upload 1 file to continue");
        }
        else{
            const callback = (response) => {
                if(response.status === 499){
                    toast.error(response.exception);
                }
                for(let key in response){
                    if(response[key].status === 200){
                        toast.success(response[key].file + " file uploaded successfully")
                    }
                    if(response[key].status === 400){
                        toast.warning("Error occurred in the "+ response[key].file + " file at row " + response[key].row +". Something is wrong with the "  +  response[key].value)
                    }
                }
                setLoading(false)
            }
            uploadFile(files,callback)
            setLoading(true)
        }
    }

    return (
        <>
            {
                loading === true?
                    <ReactLoading type={"cylon"} color={"skyblue"} height={100} width={"100%"} />
                    :
                    <Form noValidate onSubmit={handleSubmit}>
                        <Form.Group controlId="tester" className={'file_input'}>
                            <Form.Label id={'up_label'}>Testers</Form.Label>
                            <Form.Control type="file" accept=".csv" name={"testers"} disabled={loading}/>
                        </Form.Group>
                        <Form.Group controlId="device" className={'file_input'}>
                            <Form.Label id={'up_label'}>Devices</Form.Label>
                            <Form.Control type="file" accept=".csv" name={"devices"} disabled={loading}/>

                        </Form.Group>
                        <Form.Group controlId="test_device" className={'file_input'}>
                            <Form.Label id={'up_label'}>Tester-Device</Form.Label>
                            <Form.Control type="file" accept=".csv" name={"test_device"} disabled={loading}/>

                        </Form.Group>
                        <Form.Group controlId="bug" className={'file_input'} >
                            <Form.Label id={'up_label'}>Bugs</Form.Label>
                            <Form.Control type="file" accept=".csv" name={"bugs"} disabled={loading}/>
                        </Form.Group>

                        <Button type="submit" style={{width:"100%"}} disabled={loading}>Submit form</Button>
                    </Form>
            }
        </>
    )
}

export default Upload
