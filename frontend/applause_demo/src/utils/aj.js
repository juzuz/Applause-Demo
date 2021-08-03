var apiUrl = 'http://localhost:8080/'

let POSTRequest = (mappedName, data, callback) => {
    let url = apiUrl + mappedName;
    let formData = new FormData();
    for(let p in data){
        formData.append(p,data[p]);
    }
    let opts = {
        method: "POST",
        body: formData,
    };
    fetch(url,opts)
        .then((response) => {
            return response.json()
        })
        .then((data) => {
            callback(data);
        })
        .catch((error) => {
            console.log(error);
        });
};

let GETRequest = (mappedName,callback) => {
    let url = apiUrl + mappedName;

    let opts = {
        method: "GET",
        mode: 'cors'
    };
    fetch(url,opts)
        .then((response) => {
            return response.json()
        })
        .then((data) => {
            callback(data);
        })
        .catch((error) => {
            console.log(error);
        });
}


export {POSTRequest,GETRequest};