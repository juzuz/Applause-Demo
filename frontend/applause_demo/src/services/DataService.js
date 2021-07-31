import {GETRequest} from "../utils/aj";

export const GETCountryList = (callback) => {
    const mappedName = "getCountries";
    GETRequest(mappedName,callback);
}