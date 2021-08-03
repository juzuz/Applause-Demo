import {GETRequest, POSTRequest} from "../utils/aj";

export const GETCountryList = (page,callback) => {
    const mappedName = "getCountries/" + page.toString();
    GETRequest(mappedName,callback);
}
export const GETDeviceList = (page,callback) => {
    const mappedName = "getDevices/" + page.toString();
    GETRequest(mappedName,callback);
}

export const POSTSearch = (data,callback) => {
    const mappedName = "search";
    POSTRequest(mappedName,data,callback)
}