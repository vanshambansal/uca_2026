const excecutorCBFn = (resolve, rejected) => {
    const promiseState = true; // this is a boolean value that determines the state of the promise

    setTimeout(()=>{
        if(promiseState){
            resolve("Promise is resolved");
        }else{
            rejected("Promise is rejected");
        }   
        console.log("Promise is created");
        
    }, 5000);


}

// const promise = new Promise(excecutorCBFn);
// promise.then((message)=>{
//     console.log("success message is" ,message);
// })
// promise.catch((message)=>{
//     console.log(message);
// })




function PromiseCustom(executorCBFn) {
    this.state = "pending";

    let successCallback;
    let errorCallback;

    this.then = function (successCallbackFn) {
        successCallback = successCallbackFn;
    };

    this.catch = function (errorCallbackFn) {
        errorCallback = errorCallbackFn;
    };

    executorCBFn(
        (value) => {
            this.state = "fulfilled";
            successCallback(value);
        },
        (error) => {
            this.state = "rejected";
            errorCallback(error);
        }
    );
}

const promiseC1 = new PromiseCustom(executorFn);

promiseC1.then((value) => {
    console.log("Success value is: ", value);
});

promiseC1.catch((value) => {
    console.log("Error value is: ", value);
});