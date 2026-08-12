// no error as we can call it before the declaration
// foo()
// function foo() {
//     console.log("inside the foo");
    
// }


// error as it takes the properties of let Uncaught ReferenceError: Cannot access 'foo' before initialization
// foo();  
// let foo = () => {
//     console.log("inside the func");
    
// }


// error because of var hoisting Uncaught TypeError: foo is not a function
// foo()
// var foo = () => {
//     console.log("inside the func");
    
// }



// arrow function  - NAMED FUNCTION
// use function expression - In case it needs to be defined and used later on

// const foo = () => {
//     console.log("inside the func");
    
// }
// foo();




// array function - anonymous self invoking function
// used in libraries and frameworks --  used as inline function that is not reusable

// (() => {
//     console.log("inside the anony func");

// })()


// Generator function
// use * in front of function keyword to define a generaotr function
// use yield keyword to return a value from the generator  function
// use return to return a value from the generator function and terminate the generator function
// When we call the fucntion for the first time, it will return the value of generator

// function* foo(intitalValue) {
//     console.log("inside the generator start", intitalValue);
    
//     const x = yield 1;
//     console.log("inside the generator start", x);
//     yield 2;
//     yield 3;
//     return `final value  : ${4}`
// }

// var generator = foo(100)
// generator.next(); //  { value: 1, done: false }


// xml format

{/* <student>
    <name>John Doe</name>
    <age>38</age>
</student> */}

// JSON format

// const student = {
//     name: "John Doe",
//     age: 18
// }
// student.name = "vansh"
// student.college = "abc";

