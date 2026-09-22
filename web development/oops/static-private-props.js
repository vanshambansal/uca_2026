class CreateStudent{
    #marks; // private property
    #percentage; // private method
    static schoolName = "ABC School"; // static property

    constructor(name, age, email, marks){
        this.name = name;
        this.age = age;
        this.email = email;
        this.#marks = marks;
    }
    calculatePercentage(){
        this.#percentage = (this.#marks / 100) * 100;
    }
    getPercentage(){
        this.calculatePercentage();
        return this.#percentage;
    }
    getSchoolName(){
        return CreateStudent.schoolName;
    }
}

const stud1 = new CreateStudent("Vansh", 18, "@gmail.com", 90);
console.log(stud1.getPercentage());
console.log(stud1.getSchoolName());
 