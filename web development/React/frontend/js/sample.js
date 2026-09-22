function foo(number) {
    // parent component function
    // do something here
    const dynamicValue = number + 10;
    number = 20; // this is possible but we should do this because we are changing the original value of the parameter which is not a good practice
    const result = fooInner(number, callBackFunction1, callBackFunction2); // child component
    console.log("result in foo function is: ", result);


    let val1;
    let callBackFunction1 = (arg) => {
        console.log("arg in callBackFunction is: ", arg);
        val1 = arg;
    }
    let callBackFunction2 = (arg) => {
        console.log("arg in callBackFunction is: ", arg);
        val1 = arg;
    }
    
    const result1 = fooInner(number, callBackFunction1, callBackFunction2); // child component
    console.log("val1 in foo function is: ", val1);
     
}

function fooInner(value, callBackFunction1, callBackFunction2) {
    
    callBackFunction1(30);
    callBackFunction2(40);
    return value * 2;

}

foo(25);

// mutuation is the ability to change the original value of a variable or object. In programming, mutation can lead to unexpected behavior and bugs, especially in functional programming paradigms where immutability is preferred.
const name = {
    firstName: "John",
    lastName: "Doe"
};

// we are changing the state of name not the object itsself that's we we wan modify it despite being a const variable. In react we should avoid mutating the state directly and instead create a new object with the updated values and set it as the new state.
name.firstName = "Jane";
