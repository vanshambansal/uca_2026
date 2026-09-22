const arr1 = new Array(1, 2, 3);

const multiply2 = (item) => item * 2;

arr1.map((item) => item * 2);

// array map function will call callback function for each element of the array and return a new array with the results

console.log(arr1.map(multiply2));

// implement a custom map function that takes a callback function and applies it to each element of the array by using the prototype property of the Array constructor function

Array.prototype.customMap = function(callback){
    console.log(this);
    let returnArr = [];
    for(let i = 0; i < this.length; i++){
        let result = callback(this[i], i, this);
        returnArr.push(result);
    }
    return returnArr;
}
 

// custom forEach function that takes a callback function and applies it to each element of the array by using the prototype property of the Array constructor function

Array.prototype.customforEach = function(callback){
    for(let i = 0; i < this.length; i++){
        callback(this[i], i, this);
    }
}