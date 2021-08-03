import {POSTRequest} from "../utils/aj";



export const uploadFile = (data, callback) => {
    let mappedName = "uploadFile"
    POSTRequest(mappedName,data, callback);
};

