function* calculator(initialValue) {
    let result = initialValue;

    while (true) {
        const input = yield result;

        if (
            (input.operation === "add" ||
             input.operation === "multiply") &&
            typeof input.value === "number"
        ) {
            if (input.operation === "add") {
                result += input.value;
            } else {
                result *= input.value;
            }
        } else {
            result = "Invalid input";
        }
    }
}
const calc = calculator(50);

console.log(calc.next().value);
console.log(calc.next({operation: "add", value: 30}).value);
console.log(calc.next({operation: "multiply", value: 2}).value);
console.log(calc.next({operation: "add", value: "30"}).value);
console.log(calc.next({operation: "multiply", value: 0}).value);