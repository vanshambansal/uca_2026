// Destructuring for objects
const studentDetails = {
  name: "John Doe",
  age: 20,
    address: {
        street: "123 Main St",
        city: "Anytown",
        state: "CA"
    }
};

// Destructuring assignment
const { name, age, ...rest } = studentDetails;

// This is equivalent to:
// const name = studentDetails.name;
// const age = studentDetails.age;

// Destructuring for arrays
const studentMarks = [90, 80, 70, 100];

// Destructuring assignment
const [maths, science, ...rest] = studentMarks;

// This is equivalent to:
// const maths = studentMarks[0];
// const science = studentMarks[1];
// const english = studentMarks[2];