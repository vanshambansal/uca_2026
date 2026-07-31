const users = [
    {name:"Alice", age:53},
    {name:"Tim", age:74}
]

function generateTable() {
    document.getElementById("button-table").innerHTML = "";
    document.getElementById("table").innerHTML = `
        <table>

        ${users.map((user) => {
            return`
               
                <tr>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>

            `

        }).join("")}
        </table>


    `
}


document.getElementById("button-table").innerHTML = `
    <button onclick="generateTable()">
        Click here to see the table
    </button>
`


const fields = [ 
  "First Name", 
  "Last Name", 
  "Email"
]; 

function generateForm() {
    document.getElementById("button-form").innerHTML = "";
    document.getElementById("form").innerHTML = `

        ${
            fields.map((user) => {
                return `
                    <div>
                    <label>${user}</label> 
                    <input type="text"> 
                    </div>
                `
            }).join("")
        }
    
    `
}


document.getElementById("button-form").innerHTML = `
    <button onclick="generateForm()">
        Click here to see the form
    </button>
`

