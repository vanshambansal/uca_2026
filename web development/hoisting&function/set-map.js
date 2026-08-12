// Set - Equivalent to an array but with unique values
// Map - Equivalent to an array but with key-value pairs
// it is a datastructure dont confuse it with other  map

let arr1 = [ 1, 2, 1, 5, 6, 2, 5];

let set1 =  new Set(arr1)
set1.add(3)
set1.add(4)
set1.delete(4)
set1.has(4)
set1.entries()
set1.add("name")

console.log(set1);

// Set and map - base data structure is Entries
// [[key1, value1],[key2, value2],[key3, value3]]


let map1 = new Map([
    ["name" , "vansh"]
])
map1.set('age', 30)
map1.delete("age")
