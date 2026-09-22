// Promise is an constructor function that is used to create a new Promise object. A Promise object represents the eventual completion (or failure) of an asynchronous operation and its resulting value.

// A Promise object can be in one of three states:

// 1. Pending: The initial state of a Promise. The operation has not completed yet.
// 2. Fulfilled(resolved): The operation completed successfully, and the Promise has a resulting value.
// 3. Rejected: The operation failed, and the Promise has a reason for the failure.

// A Promise object is created using the Promise constructor function, which takes a single argument: a callback function that defines the asynchronous operation. The callback function takes two arguments: resolve and reject, which are functions that are used to change the state of the Promise.

const callbackFunction = (resolve, rejected) => {
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

const promise = new Promise(callbackFunction);
promise.then((message)=>{
    console.log("success message is" ,message);
})
promise.catch((message)=>{
    console.log(message);
})






// method chaining in js
let st1 = "vansham";
st1.concat("-c1").concat("-c2").concat("-c3")



// we can call methods on string primitive values because js automatically converts the string primitive value to a string object when we call a method on it. This is called autoboxing. After the method is called, the string object is converted back to a string primitive value. This is called unboxing.

// this confirms that everything in js is an object and everything is a reference type except for primitive values. Primitive values are immutable and cannot be changed. When we call a method on a primitive value, js creates a temporary string object, calls the method on it, and then discards the temporary string object. This is why we can call methods on primitive values.

let str2 = "vansham";
let str3 = new String("vansham");



