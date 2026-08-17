// var obj1 = {
//     name : "Vansh",
//     age : 18,
//     email : '@gmail.com'
// }

// Object.create() to create objects and it has a value of prototype in it

// var obj2 = Object.create(obj1)


// var sourceObj = {
//     name : "Vansh",
// }
// var targetObj = {
//     age : 18,
//     email : '@gmail.com'
// }

// doesnt create a new object but it copies the values of the source object to the target object

// Object.assign(sourceObj , targetObj);

// creates a new object and also changes the source object
// var obj = Object.assign(sourceObj , targetObj);

// // creates a new object but doesnt change the source
// var obj = Object.assign({}, sourceObj , targetObj);



// this is tough to create multiple objects with same properties and methods so we use constructor function to create multiple objects with same properties and methods

// const student1 = {
//     name : "Vansh",
//     age : 18,
//     email : '@gmail.com'
// }

// const student2 = {
//     name : "Rahul",
//     age : 20,
//     email : '@gmail.com'
// }



// factory function - a function that creates a factry of objects with same properties and methods -- used in angular.Js 
// different objects have no relation with each other and they are independent of each other



// function createStudent(name, age, email, marks){
//     let maxMarks = 100;
//     return {
//         name : name,
//         age : age,
//         email : email,
//         percentage : function(){
//             return (marks / maxMarks) * 100;
//         }
//     };
// }

// const student3 = createStudent("Vansh", 18, "@gmail.com", 90);
// const student4 = createStudent("Rahul", 20, "@gmail.com", 80);


// Constructor function - a function that creates a constructor of objects with same properties and methods -- used in react.Js
// different objects have a relation with each other and they are dependent on each other
// this is a special keyword that refers to the current object and it is used to access the properties and methods of the current object



// function constructStudent (name, age, email, marks){
    
//     this.name = name;
//     this.age = age;
//     this.email = email;
//     this.marks = marks;

// }

// const student5 = new constructStudent("Vansh", 18, "@gmail.com", 90);
// const student6 = new constructStudent("Rahul", 20, "@gmail.com", 80);



// what is prototype - a prototype is an object that is associated with every functions and objects in javascript and it is used to add properties and methods to the constructor function and it is also used to inherit properties and methods from other objects

// function.prototype - a property that is used to add properties and methods to the constructor function and it is also used to inherit properties and methods from other objects

// function.prototype and object.__proto__ is same but function.prototype is used to add properties and methods to the constructor function and object.__proto__ is used to inherit properties and methods from other objects


// constructStudent.prototype.percentage = function(){
//         return (this.marks / 100) * 100;
// }

// student5.percentage()
// student6.percentage()



// why need class ? 
// classes are a way to create objects in javascript and they are a syntactic sugar over the constructor function and prototype-based inheritance

// transpillers - transform the code to javaascript code that is compatible with older browsers and javascript engines




const obj = {
    name : "Vansh",
    age : 18,
    email : '@gmail.com'
}


const objByAssign = Object.assign({}, obj);
const objByCreate = Object.create(obj);

objByCreate //(it is empty as it is created from obj and it has no properties of its own but it has access to the properties of obj through prototype chain)

obj.name = "Rahul";

objByAssign.name // "Vansh" (it is not affected by the change in obj as it is a copy of obj)

objByCreate.name // "Rahul" (it is affected by the change in obj as it is created from obj and it has access to the properties of obj through prototype chain)