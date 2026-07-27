const worker = new Worker("./worker.js")

console.log("log before data");
worker.postMessage("start");
worker.onmessage = function(event){
    console.log(event.data);
    
}
console.log("log after data");
