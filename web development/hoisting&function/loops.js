let arr = [1, 2, 3, 4, 5];

const student = {
    name: "John Doe",
    age: 18,
    college : "ABC",
    email: "@gmail.com"
};

// FOR LOOP

// for(let i = 0; i < arr.length; i++) {
//     console.log("The value of i is ", arr[i]);
//     if(arr[i] == 4) continue;
//     if(arr[i] == 4) break;
// }


// FOR IN LOOP - gives the keys of objects and arrays


// for (let i in arr) {
//     console.log(arr[i]);
// }
// for (let i in student) {
//     console.log(student[i]);
// }


// FOR OF LOOP - iterates over the values of the array


// for (let i of arr) {
//     console.log(i);
    
// }

// for each function - iterated over the value of the array and execute a function for each value
// we cant use break / continue  in for each function

// arr.forEach((element, index, arr) => {

//     console.log("the index is", index);
//     console.log("the multiplied value is", element * 2);
    
// });


// Arrays.some - check condition if any element satisfies
// Arrays.every - check condition if every  element satisfies

// arr = [2, 4, 6, 7, 9]

// const value = arr.some((element) => {
//     return element % 2 == 0;
    
// })
// console.log(value);

// arr.every((element) => {
//     return element % 2 == 0;
// })


// Array.find
// Array.findIndex --- -1 if not found

// arr.find((item) => {
//     return item % 2 == 0;
// })

// Array.filter

// arr.filter((item) => {
//     return item%2 == 0;
// })



// rest operator - ...
// spread operator - ... used to combine elements of multiple array/objects

// const arr1 = [1, 2, 3];
// const arr2 = [4, 5, 6];

// const arr3 = [...arr1, ...arr2];
// console.log(arr3);

const studentpersonal = {
    name: "John Doe",
    age: 18,
};

const studentcollege = {
    college : "ABC",
    email: "@gmail.com"
};

const totaldetails = {...studentcollege, ...studentpersonal}

// console.log(totaldetails);

// const totaldetailsArr = [studentcollege, studentpersonal]

// console.log(totaldetailsArr);


// rest operator

// sum(1, 2);
// sum(1, 2, 3);
// sum(1, 2, 3, 4);

// function sum(...numbers) {
//     let sum = 0;
//     for(let number of  numbers) {
//         sum += number;
//     }
//     return sum
// }


// one more usecase for rest

const {college , ...otherdetails} = totaldetails;
console.log(otherdetails)
