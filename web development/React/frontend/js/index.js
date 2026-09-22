// document.getElementById("appcontent").innerHTML = "content from js";

// Template Literal = Mutiline string in js denoted by ``


let  productList1 = [];
loadDataFromServer();
renderProducts(productList1);


function loadDataFromServer(){

    setTimeout(() => {
        productList1 = [
            {
                srno : 1,
                product : "tv",
                price : 50000
            },
            {
                srno : 2,
                product : "mobile",
                price : 10000
            },
            {
                srno : 3,
                product : "ac",
                price : 40000
            }
        ]
        console.log(productList1);
        renderProducts(productList1);
        
    }, 2000);
}
function renderProducts(productList1){
    if(productList1.length === 0){
        document.getElementById("appcontent").innerHTML = `

        <h2>
        Loading data from the server
        </h2>

        `
        return;
    }

    


        document.getElementById("appcontent").innerHTML = `

                <table>
                <thead>
                    <th>Sr No.</th>
                    <th>Product</th>
                    <th>price</th>
                </thead>
                <tbody>
                    ${productList1.map((item) =>{
                       return `
                        <tr>
                        <td>${item.srno} </td>
                        <td>${item.product} </td>
                        <td>${item.price} </td>
                        </tr>
                        `
                    })}
                </tbody>
                </table>


        `


}




