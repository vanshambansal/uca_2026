// BROWSER API - Web Workers

// always remember js can never create a thread all mutithrading is handled by BROWSER api js is always multithreaded


console.log("code before web worker");


// browser api code
const webworker1 = new Worker("./js/worker.js")

webworker1.postMessage(2000000000);
webworker1.onmessage = function(event) {
    document.getElementById("datafromworker").innerHTML = "data from worker thread "+ event.data;
}


console.log("code after web worker");
