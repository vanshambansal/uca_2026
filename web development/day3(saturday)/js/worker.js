console.log("start of inside the web worker");

// // implement a heavy processing function

function heavyProcessing(number) {

    let startTime = Date.now()
    let sum =0;
    for(let i=0; i < number; i++){
        sum += i;
    }
    let endTime = Date.now();
    console.log((endTime - startTime)/ 1000);
    
    self.postMessage(sum);
}

self.onmessage = function(event){
    const datafrommainthread = event.data;
    console.log("data from main thread ", datafrommainthread)
    heavyProcessing(datafrommainthread);
}
console.log("end of inside the web worker");

