import React,{useState} from 'react'
import {Form, Button} from 'react-bootstrap'
import '../css/uploadForm.css';
import {uploadFile} from "../services/FileService";
function Upload() {

    const handleSubmit=(e) => {
        e.preventDefault();
        let files = {
            tester: e.target.tester.files[0],
            devices: e.target.devices.files[0],
            test_device: e.target.test_device.files[0],
            bugs: e.target.bugs.files[0]
        };

        const callback = (val) => {
            console.log(val);
        }

        uploadFile(files,callback)
    }

    return (
        <div>
        <Form noValidate onSubmit={handleSubmit}>
            <Form.Group controlId="tester" className={'file_input'}>
                <Form.Label id={'up_label'}>Testers</Form.Label>
                <Form.Control type="file" accept=".csv" name={"testers"}/>
            </Form.Group>
                <Form.Group controlId="device" className={'file_input'}>
                    <Form.Label id={'up_label'}>Devices</Form.Label>
                    <Form.Control type="file" accept=".csv" name={"devices"}/>

                </Form.Group>
                <Form.Group controlId="test_device" className={'file_input'}>
                    <Form.Label id={'up_label'}>Tester-Device</Form.Label>
                    <Form.Control type="file" accept=".csv" name={"test_device"}/>

                </Form.Group>
                <Form.Group controlId="bug" className={'file_input'} >
                    <Form.Label id={'up_label'}>Bugs</Form.Label>
                    <Form.Control type="file" accept=".csv" name={"bugs"}/>
                </Form.Group>

            <Button type="submit">Submit form</Button>
        </Form>
        </div>
    )
}

export default Upload
