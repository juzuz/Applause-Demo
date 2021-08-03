import React, {useState} from 'react'
import Home from '../components/Home'
import logo from "../assets/title.png";
function HomeView() {

    const nav = ["Search","Upload"]
    const [curPage,setCurPage] = useState("Upload")

    const handleClick = (e) =>{
        if(e.target.outerText === "Upload"){
            setCurPage("Upload")
        }
        else{
            setCurPage("Search")
        }
    }
    return (
        <div >
            <div className="navBar">
                {
                    nav.map((val, idx) => (
                        <div className={"button"} style={{backgroundColor:val === curPage?"#C6E8EE":""}} onClick={handleClick}>
                            {val}
                        </div>
                    ))
                }
                <hr/>
            </div>
            <header className="App-header">
                <div>
                    <img src={logo}/>
                </div>
            </header>
            <Home curPage = {curPage} />
        </div>
    )
}

export default HomeView
