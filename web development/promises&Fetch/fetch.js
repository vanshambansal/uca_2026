const fetchRequestObject = fetch("http://localhost:5000/");

let successR;

fetchRequestObject.then((successResponse) => {
    console.log("successResponse is", successResponse);

    successR = successResponse;
})

fetchRequestObject.catch((errorResponse) => {
    console.log("errorResponse is", errorResponse);
    
})
console.log("fetchRequestObject is", fetchRequestObject);

const fetchRequestObjectPost = fetch("http://localhost:5000/", {

    method: "POST",
    headers: {
        "Content-Type": "spplication/json",
        Authorization: "",
    },
    body: {
        username: "name1",
    },

})



// custom fetch implementaion
// fetch - return

function fetchCustom(url, {}) {
    return new Promise(executorFunction);

    function executorFunction(resolve, reject) {
        // should make the api calls and return promise

        const xhr1 = new XMLHttpRequest();
        
        xhr1.opn("GET", url);
        xhr1.send();

        xhr1.onreadystatechange =  function() {
            if(xhr1.readyState === "4") {
                let reponse = xhr1.response;
                if (xhr1.status === "200") resolve(response);
                else reject(response);
            }
        }

    }
}

const responsePromise = fetchCustom("https://dummyjson.com/products/1");

responsePromise.then((success) => {});
responsePromise.catch((success) => {});
