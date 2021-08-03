import React,{useEffect,useState} from 'react'
import {Dropdown, Card, ListGroup,Button, ButtonGroup} from 'react-bootstrap'
import {GETCountryList,GETDeviceList,POSTSearch} from "../services/DataService";
import {FaFlag, FaMobileAlt,FaTimes,FaPlus} from 'react-icons/fa'
import { toast } from 'react-toastify';
import ReactLoading from "react-loading";
const pastelColors=  ["#BAB8F3","#F2C1F3","#C6E8EE","#F7DDCD"]


function Search() {

    // Conditional of what to do, when choosing to add a device or country
    const [filterType,setFilterType] = useState("Filter Type")
    // The chosen country or device after selecting a filter type
    const [chosen,setChosen] = useState("")

    // List of all countries (by pages)
    const [countryList,setCountryList] = useState([]);
    const [countryFilter,setCountryFilter] = useState([]);
    // List of all devices (by pages)
    const [deviceList,setDeviceList] = useState([]);
    const [deviceFilter,setDeviceFilter] = useState([]);

    // Variables to check what page to request next and whether to show a load more.
    const [totalNumCountry,setTotalNumCountry] = useState(0);
    const [countryPage,setCountryPage] = useState(0);
    const [totalNumDevice,setTotalNumDevice] = useState(0);
    const [devicePage,setDevicePage] = useState(0);


    // Boolean whether to show results
    const [searchRequested,setSearchRequested] = useState(false);
    // A list of our results from the query
    const [searchResult,setSearchResult] = useState([]);

    const [loading,setLoading] = useState(false);

    // On render, get first page of device and country
    useEffect(()=>{
        const callbackC =(data) => {
            setCountryList(data.content);
            setTotalNumCountry(data.totalElements)
        }
        const callbackD =(data) => {
            setDeviceList(data.content);
            setTotalNumDevice(data.totalElements)
        }

        let page = 0
        GETCountryList(page,callbackC);
        GETDeviceList(page,callbackD)
    },[])

    // Set the chosen device or country, but if Load More, get the next page
    // of the list and add concat it to our current list.
    const handleSelect = val =>{
        if(val !== "Load")
            setChosen(val)
        else{
            if(filterType === "Device")
            {
                let nextPage = devicePage +1;
                setDevicePage(nextPage)
                const callback = (data) =>{
                    setDeviceList(deviceList.concat(data.content))
                }
                GETDeviceList(nextPage,callback);
            }
            else{
                let nextPage = countryPage +1;
                setCountryPage(nextPage)
                const callback = (data) =>{
                    setCountryList(countryList.concat(data.content))
                }
                GETCountryList(nextPage,callback);
            }

        }
    }

    // Adding a new filter and do some error checking
    const handleAdd = () => {
        // Did not choose a filter type
        if(filterType === "Filter Type"){
            toast.info("Choose a filter type before adding!")
        }
        else{
            // Chose filter type, but not a value
            if (chosen === ""){
                toast.warning("Choose an option!")
            }
            else{
                // If choose ALL remove all existing by their filter type
                if(chosen === "ALL"){
                    if(filterType === "Country"){
                        setCountryFilter([].concat(chosen));
                    }
                    else{
                        setDeviceFilter([].concat(chosen));
                    }
                }
                else{
                    // Actually chose a device or country
                    if(filterType === "Country"){
                        // Already Exists
                        if(countryFilter.includes(chosen)){
                            toast.error("Already in the list")
                        }
                        // If All is in the list, remove it and add new device or countru
                        else if(countryFilter.includes("ALL")){
                            setCountryFilter(countryFilter.filter(e => e !== "ALL").concat(chosen))
                        }
                        // all correct
                        else{
                            setCountryFilter(countryFilter.concat(chosen));
                        }
                    }
                    else{
                        // Same as above jsut for a device
                        if(deviceFilter.includes(chosen)){
                            toast.error("Already in the list")
                        }
                        else if(deviceFilter.includes("ALL")){
                            setDeviceFilter(deviceFilter.filter(e=> e!== "ALL").concat(chosen))
                        }
                        else{
                            setDeviceFilter(deviceFilter.concat(chosen));
                        }
                    }
                }
                // Reset the values to normal and prepare for the next filter
                setFilterType("Filter Type");
                setChosen("");
            }
        }
    }

    // Put the filter data in a data object and post to server
    const handleSearch = () => {
        let data = {
            country: countryFilter,
            device: deviceFilter
        }

        // Set Query Results
        const callback = (data) => {
            setSearchResult(data);
            setSearchRequested(true);

            let timer1 = setTimeout(() => setLoading(false), 3 * 1000)
        }
        POSTSearch(data,callback)
        setLoading(true);

    }

    // Through the category name and idx number delete a element in the filter list.
    const handleRemove = (filterType,idx) => {
        // Filter out and reset.
        if(filterType==="Country"){
            const newList = countryFilter.filter((elem,index) => {return index !== idx});
            setCountryFilter(newList)
        }
        else{
            const newList = deviceFilter.filter((elem,index) => {return index !== idx});
            setDeviceFilter(newList)
        }
    }

    return (
        <>
            {
                loading=== true?
                    <ReactLoading type={"bubbles"} color={"yellowgreen"} height={100} width={"100%"} />
                    :
                    <div>
                        <div style={{margin:'2%', display:'flex',flexDirection:'column'}}>
                            <h5 style={{color:"black",display:'flex',paddingLeft:'3%'}}>Filter Tester</h5>

                            <hr style={{color:"black"}}/>
                        </div>
                        {
                            searchRequested === false?
                                <div>
                                    <Card
                                        border="light"
                                        style={{
                                            border:"none",
                                            display:'inline-block',
                                            marginRight:'0',
                                            width: '36rem',
                                            height: '25rem',
                                            ackgroundColor:'#FEFEFF'
                                        }} >
                                        <div style={{display:'flex',flexDirection:"column",alignItems:'flex-start'}}>
                                            <div style={{fontSize:"large"}}>
                                                Choose a filter and click on +
                                            </div>
                                            <div style={{display:'flex',width:'100%',justifyContent:"space-between"}}>
                                                <div style={{display:'flex'}}>
                                                    <div style = {{display:'flex',flexDirection:'column',justifyContent:'space-around',fontSize:"medium"}}>
                                                        Find a Tester
                                                        {
                                                            filterType === "Filter Type"?
                                                                "":
                                                                <>
                                                                    {
                                                                        filterType === "Country"?
                                                                            " from the "
                                                                            :
                                                                            " with the "
                                                                    }
                                                                </>
                                                        }
                                                    </div>
                                                    <Dropdown
                                                        as={ButtonGroup}
                                                        onSelect={(val) => {
                                                            setFilterType(val);setChosen("")
                                                        }}
                                                        style={{marginLeft:"10px"}}
                                                    >
                                                        <Dropdown.Toggle
                                                            style={{
                                                                backgroundColor:pastelColors[Math.floor(Math.random() * pastelColors.length)]
                                                            }}
                                                        >
                                                            {filterType}
                                                        </Dropdown.Toggle>
                                                        <Dropdown.Menu>
                                                            <Dropdown.Item eventKey={"Country"} style={{padding:'0'}} >
                                                                <div style={{textAlign:'center'}}>
                                                                    <FaFlag/>
                                                                    <div>Country</div>
                                                                </div>
                                                            </Dropdown.Item>
                                                            <Dropdown.Divider/>
                                                            <Dropdown.Item eventKey={"Device"} style={{padding:'0'}}>
                                                                <div style={{textAlign:'center'}}>
                                                                    <FaMobileAlt/>
                                                                    <div>Device</div>
                                                                </div>
                                                            </Dropdown.Item>
                                                        </Dropdown.Menu>
                                                    </Dropdown>
                                                    {
                                                        filterType === "Filter Type"?
                                                            null
                                                            :
                                                            <>
                                                                {
                                                                    filterType === "Country" ?
                                                                        <Dropdown as={ButtonGroup} onSelect={val => setChosen(val)}>
                                                                            <Dropdown.Toggle
                                                                                style={{
                                                                                    backgroundColor:pastelColors[Math.floor(Math.random() * pastelColors.length)]
                                                                                }}
                                                                            >
                                                                                {chosen}
                                                                            </Dropdown.Toggle>
                                                                            <Dropdown.Menu style={{ textAlign: 'center'}}>
                                                                                <Dropdown.Item eventKey={"ALL"} style={{padding:0}}>
                                                                                    <div>ALL</div>
                                                                                </Dropdown.Item>
                                                                                {
                                                                                    countryList.map((countryAb, idx) => (
                                                                                        <Dropdown.Item eventKey={countryAb} style={{padding: '0'}}>

                                                                                            <div>{countryAb}</div>
                                                                                        </Dropdown.Item>
                                                                                    ))
                                                                                }
                                                                                {
                                                                                    countryList.length < totalNumCountry?
                                                                                        <Dropdown.Item eventKey={"Load"} style={{padding: '0'}}>
                                                                                            <div>Load More</div>
                                                                                        </Dropdown.Item>
                                                                                        : null
                                                                                }
                                                                            </Dropdown.Menu>
                                                                        </Dropdown>
                                                                        :
                                                                        <Dropdown as={ButtonGroup} onSelect={handleSelect}>
                                                                            <Dropdown.Toggle
                                                                                style={{
                                                                                    backgroundColor:pastelColors[Math.floor(Math.random() * pastelColors.length)]
                                                                                }}
                                                                            >{chosen}</Dropdown.Toggle>
                                                                            <Dropdown.Menu style={{ textAlign: 'center'}}>
                                                                                <Dropdown.Item eventKey={"ALL"} style={{padding:0}}>
                                                                                    <div>ALL</div>
                                                                                </Dropdown.Item>
                                                                                {
                                                                                    deviceList.map((info, idx) => (
                                                                                        <Dropdown.Item eventKey={info.description} style={{padding: '0'}}>

                                                                                            <div>{info.description}</div>

                                                                                        </Dropdown.Item>
                                                                                    ))
                                                                                }
                                                                                {
                                                                                    deviceList.length < totalNumDevice?
                                                                                        <Dropdown.Item eventKey={"Load"} style={{padding: '0'}}>
                                                                                            <div>Load More</div>
                                                                                        </Dropdown.Item>
                                                                                        : null
                                                                                }

                                                                            </Dropdown.Menu>
                                                                        </Dropdown>
                                                                }
                                                            </>
                                                    }
                                                </div>
                                                <Button onClick={handleAdd}>
                                                    <FaPlus/>
                                                </Button>
                                            </div>
                                        </div>

                                        <hr />

                                        <div>
                                            <ListGroup as={'ul'} >
                                                {
                                                    countryFilter.map((filt,idx) => (
                                                        <ListGroup.Item as ='li'>
                                                            <div className={"listgroup-item"}>
                                                                <FaTimes
                                                                    style ={{display:'flex',height:"auto",fontSize:"22px",color:'white'}}
                                                                    onClick={() => handleRemove("Country",idx)}/>
                                                                <div style={{  color:"white",width:"80%"}}>
                                                                    {"Country: " + filt}
                                                                </div>
                                                            </div>
                                                        </ListGroup.Item>
                                                    ))
                                                }
                                                {
                                                    deviceFilter.map((filt,idx) => (
                                                        <ListGroup.Item as ='li'>
                                                            <div className={"listgroup-item"}>
                                                                <FaTimes
                                                                    style ={{display:'flex',height:"auto",fontSize:"22px",color:'white'}}
                                                                    onClick={()=> handleRemove("Device",idx)}
                                                                />
                                                                <div style={{  color:"white",width:"80%"}}>
                                                                    {"Device: " + filt}
                                                                </div>
                                                            </div>
                                                        </ListGroup.Item>
                                                    ))
                                                }
                                            </ListGroup>
                                        </div>
                                        <hr/>

                                        <Button type='button' style ={{width:"100%"}}onClick= {handleSearch} >
                                            Search
                                        </Button>
                                    </Card>
                                </div>
                                :
                                <>
                                    {
                                        searchResult.length === 0 ?
                                            <div>
                                                <div className={"right messages"}>
                                                    <div className={"message tail"}>
                                                        There are no testers that fit your criteria!
                                                        Change some filters and try again!
                                                    </div>

                                                </div>
                                            </div>
                                            :

                                            <ol style={{padding:"10px",maxHeight:"30rem",overflowX:"hidden",overflowY:"scroll"}}>
                                                <li className={"item-container"}>
                                                    <div className={"header-container"}>Name</div>
                                                    <div className={"header-container"}>Experience</div>
                                                    <div className={"header-container"}>Actions</div>
                                                </li>
                                                <hr/>
                                                {
                                                    searchResult.map((val, idx) => (
                                                        <>
                                                            <li className={"item-container"}>
                                                                <div className={"attribute-container"}>
                                                                    {val[0].firstName + " " + val[0].lastName}
                                                                </div >
                                                                <div className={"attribute-container"}>
                                                                    {val[1]}
                                                                </div>
                                                                <div className={"attribute-container"}>
                                                                    <Button style={{width:"50%"}}>
                                                                        Request Tester
                                                                    </Button>
                                                                </div>
                                                            </li>
                                                            <hr/>
                                                        </>

                                                    ))
                                                }
                                            </ol>
                                    }
                                    <div>
                                        <Button onClick={()=>setSearchRequested(false)} style ={{width:"90%"}} type={"button"}>
                                            Adjust Filters
                                        </Button>
                                    </div>
                                </>
                        }
                    </div>
            }

        </>
    )
}

export default Search
