
function apiCall() { 
    fetch('https://dummyjson.com/users')
        .then((response) => response.json())
        .then((data)=> {
            
            if(data.users.length === 0){
                self.postMessage("No users found");
                return;
            }

            const users = data.users.map((user)=>({
                name : `${user.firstName}`,
                status : user.id % 2 ===0
            }));

            self.postMessage(users);

        
        })
        .catch(()=>{
            self.postMessage("error while fetching the users");
        });
}
self.onmessage = function(event){
    if(event.data === "start"){
        console.log("started the api call");
        apiCall();
    }else{
        console.log("incorrect response");
        
    }
}