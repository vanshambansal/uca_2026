// browser apis's


// network requests=>


// 1) XMLHttpRequest- xhr
// used for making networks reuqests to the server
// 2) fetch

// 1> XMLHttpRequest ( we can control whether we want code in asyn mode or sync mode not all the browser apis give this feature )

// normal js code
console.log("code before the browser api")

const xhr1 = new XMLHttpRequest() // alocated memory and store the reference int the variable
// xhr1.open("Type", "URL", "isAsync")

xhr1.open("GET", "https://dummyjson.com/products", true) // true - async, false - sync



// some other code
xhr1.onload = function(){
    console.log(xhr1.responseText)
}

xhr1.send() // send the request to the server
// local server url - 127.0.0.1 === 0.0.0.1 == localhost

// other js code
console.log("code after the browser api");




//next go to index_ww.js