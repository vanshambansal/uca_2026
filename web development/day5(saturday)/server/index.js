import http from "http"

let val = "hello world";
console.log("hey", val);

const server = http.createServer((req, res) => {

        res.writeHead(200, {"content-type" : "application/json"})
        res.end(
            JSON.stringify({
                name:"hello",
                description: "hello world"
            })
        )
        
    // if (req.url == '/') {
    //     res.end("home page");
    // } else {
    //     res.end("other page");
    // }

})

// server.listen(3000, () => {
//     console.log("server is running");

// })

const hostname = "127.0.0.1";
const port = 3000;
server.listen(port, hostname);