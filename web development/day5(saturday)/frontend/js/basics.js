// self invoking function
// (function foo(input) {
//     console.log("INput params", input);
    
// })("Hello");

// const foo = (input) => {
//     console.log("INput params", input);
    
// }

// foo("Hello");




// // Array - Map :- it is the function that accep a call back fucntion as an argument.
// It creates a new array 
// That callback function is excecuted on each ele,ment of the array and the return value becomes element of new array


let arr1 = [1, 2, 3, 4, 5];

// const arrMultiply = arr1.map((item) => {
//     return item * 2;
// })


// Call back function: Passed as an argument to another functiion

const arrMultiply = arr1.map(multiply);

function multiply(item){
    return item * 2;
}


console.log(arrMultiply);

