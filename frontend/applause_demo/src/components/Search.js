import React,{useEffect,useState} from 'react'
import { ButtonGroup} from 'react-bootstrap'
import {GETCountryList} from "../services/DataService";
function Search() {


    const [countryList,setCountryList] = useState([]);
    const [deviceList,setDeviceList] = useState([]);

    useEffect(()=>{
        const callback =(data) => {
            setCountryList(data);
        }
        GETCountryList(callback);
    },[])

    return (
      <div style ={{color:"black"}}>
          {
              countryList.map((country) => (<div>{country}</div>))
          }
      </div>
    )
}

export default Search
