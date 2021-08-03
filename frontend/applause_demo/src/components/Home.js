import React from 'react'
import Upload from "./Upload";
import {Card} from 'react-bootstrap'
import Search from "./Search";
function Home(props) {

    const {curPage} = props;

    return (
        <div className='homeContainer'>
            <Card style={{ border:"none",width: '40rem',height: '40rem',backgroundColor:'#FDFEFF' }}>
                {
                    curPage ==="Upload"?
                        <Upload/>:<Search/>
                }

            </Card>
        </div>
    )
}

export default Home
