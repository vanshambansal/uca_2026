// difference between function declaration and arrow function
// 1. Hoisting: Function declarations are hoisted to the top of their scope, meaning they can be called before they are defined in the code. Arrow functions, on the other hand, are not hoisted and must be defined before they are called.
// 2. Syntax: Function declarations use the function keyword, while arrow functions use the => syntax. Arrow functions also have a more concise syntax, especially for single-line functions that return a value.
// 3. this keyword: Function declarations have their own this context, which is determined by how the function is called. Arrow functions, on the other hand, do not have their own this context and instead inherit it from the surrounding scope.
// In an arrow function, this keyword is inherited from the parent context

// cannot be called using new keyword, arrow functions do not have their own this context and cannot be used as constructors. Function declarations can be called using the new keyword to create new instances of an object.

// arrow function this refers to the parent only

// arrow functions does not have to default arguments objects


// function declaration


function multiplyBy2(item) {
    return item * 2;
}

// arrow function

const mutiplyBy2Arrow = (item) => {
    return item * 2;
};

// const multiplyBy2ArrowShort = (item) => item * 2;

function outerFunction() {
    console.log(this); // this refers to the outer function
    this.normalFunction = function() {
        console.log(this);
        function innerFunctionNormal() {
            console.log("this is inside normal inner function ",this);
        }
        innerFunctionNormal();
    }
    this.arrowFunction = () => {
        console.log(this);
        function innerFunctionArrow() {
            console.log("this is inside arrow inner function ",this);
        }
        innerFunctionArrow();
    }
}

const obj = new outerFunction();
obj.normalFunction();
obj.arrowFunction();



// arrow function

const arrowFunction = (name, age) => {
    console.log(name);
    console.log(age);
}

const normalFunction = function(name) {
    console.log(name);
    console.log(arguments); // arguments is an array like object that contains all the arguments passed to the function
    console.log(arguments[0]); // arguments is an array like object that contains all the arguments passed to the function
}