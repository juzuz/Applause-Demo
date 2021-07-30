import React from 'react'
import './../css/home.css'
import {Card, Button, ButtonGroup} from 'react-bootstrap'
function Home() {
    return (
        <div className='homeContainer'>
            {/* F4EBD2 */}
            <Card border="secondary" style={{ width: '40rem',height: '40rem',backgroundColor:'white' }}>
            <ButtonGroup aria-label="Basic example">
            <Button variant="light">Left</Button>
            <Button variant="light">Middle</Button>
            <Button variant="light">Right</Button>
            </ButtonGroup>
            </Card>
        </div>
    )
}

export default Home
