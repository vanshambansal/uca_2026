class CreateStudent{
    constructor(name, age, email, marks){
        this.name = name;
        this.age = age;
        this.email = email;
        this.marks = marks;
    }
    percentage(){
        return (this.marks / 100) * 100;
    }
}

const student3 = new CreateStudent("Vansh", 18, "@gmail.com", 90);
const student4 = new CreateStudent("Rahul", 20, "@gmail.com", 80);


// class is just a keyword if we do typeof CreateStudent it will return function and if we do typeof student3 it will return object because class is just a syntactic sugar over the constructor function and prototype-based inheritance
