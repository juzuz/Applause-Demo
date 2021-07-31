import React,{useState} from 'react'
import './../css/home.css'
import Upload from "./Upload";
import {Card, ToggleButton, ButtonGroup} from 'react-bootstrap'
import { FaUpload, FaSearch } from 'react-icons/fa'
import Search from "./Search";
function Home() {

    const [checked,setChecked] = useState(false)
    const [radioValue, setRadioValue] = useState('1');
    const radios = [
        { name: 'Upload CSV', value: '1' ,icon:<FaUpload/>},
        { name: 'Search', value: '2' ,icon:<FaSearch/>}
    ];

    return (
        <div className='homeContainer'>
            {/* F4EBD2 */}
            <Card border="light" style={{ width: '40rem',height: '40rem',backgroundColor:'white' }}>
                <ButtonGroup className="mb-2">
                    {radios.map((radio, idx) => (
                        <ToggleButton
                            key={idx}
                            id={`radio-${idx}`}
                            type="radio"
                            variant="light"
                            name="radio"
                            value={radio.value}
                            checked={radioValue === radio.value}
                            onChange={(e) => setRadioValue(e.currentTarget.value)}
                        >
                            {radio.icon}
                            {radio.name}
                        </ToggleButton>
                    ))}
                </ButtonGroup>
                {
                    radioValue === "1"?
                        <Upload/>: <Search/>
                }

            </Card>
        </div>
    )
}

export default Home
