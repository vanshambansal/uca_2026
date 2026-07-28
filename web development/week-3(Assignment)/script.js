const worker = new Worker("./worker.js")

console.log("log before data");
worker.postMessage("start");
worker.onmessage = function(event){
    // console.log(event.data);

    const userDiv = document.getElementById("users");

    if(typeof event.data === "string"){
        userDiv.innerHTML = event.data;
        return;
    }

    userDiv.innerHTML = `

    <div>
        ${event.data.map((user) => {
            return `
            <div>
            <span> ${user.name} </span>
            <span> ${user.status ? "Active" : "Inactive"} </span>
            </div>
            `
        }).join("")
        }
    </div>

    `

    
}
console.log("log after data");
