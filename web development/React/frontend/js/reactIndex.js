
productList = [
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
 


// main jsx start from here


const app = document.getElementById("reactapp");
const root = ReactDOM.createRoot(app);


root.render(
    <React.StrictMode>
        <ReactTitle title="React Application" key="title"></ReactTitle>
        <ManualLikes></ManualLikes>
        <RenderProducts productList={productList}></RenderProducts>
        <Form></Form>
    </React.StrictMode>
);

function ReactTitle(props){
    props.title = "React Application updated";
    // props are immutable we change the value of props 
    console.log("props.title in ReactTitle component is: ", props.title);
    return <h2>{props.title}</h2>
}


function RenderProducts({productList}){
    const [products, setProducts] = React.useState([]);
    const [likes, setLikes] = React.useState(1);

    let localLikes = 0;
    let localLikesUsingRef = React.useRef(0);

    function updateLocalVariableLikes() {
        localLikes++;
        setLikes(likes + 1);
        localLikesUsingRef.current++;
        console.log("localLikes is: ", localLikes);
        console.log("likes is: ", likes);
        console.log("localLikesUsingRef.current is: ", localLikesUsingRef.current);
    }

    React.useEffect(() => {
        setTimeout(() => {
            setProducts(productList);
        }, 2000);
    }, []);

    return (
       <>
        {products.length === 0 ? (
         <h3>Loading data from the server</h3> ):(
             <RTable data={products}></RTable>
         
         )}
        <Button eventHandler={updateLocalVariableLikes} text="Update Local Variable"></Button>

       </> 
    )
}



function Form() {
    const [formElements, setFormElements] = React.useState(["id1", "id2", "id3"]);

    function reverseOrderOfFormElements() {
        
        // if our dependency array is empty, then the function will be created only once and will not be recreated on every re-render of the component that's why it would give wrong value of formElements because it will always refer to the initial value of formElements which is ["id1", "id2", "id3"]
        // if our dependency array is not empty, then the function will be recreated on every re-render of the component

        // setFormElements([...formElements].reverse());

        // so instead use callback if we want to keep our dependency array empty and still get the latest value of formElements
        setFormElements((prevFormElements) => {
            return [...prevFormElements].reverse();
        });

    }

    // const reverseOrderOfFormElementsMemoized = React.useCallback(reverseOrderOfFormElements, [formElements]);
    const reverseOrderOfFormElementsMemoized = React.useCallback(reverseOrderOfFormElements, []);
    
    return (
        <>
        <form>
            {
                formElements.map((item) => {
                    return (
                        <div key={item} style={{padding: "10px 0px"}}>
                            <input type="text" placeholder={`Enter ${item}`} />
                        </div>
                    )
                })
            }
        </form>
            {/* <Button text="Reverse Order of Form Elements" eventHandler={reverseOrderOfFormElements}></Button> */}
            <Memoizedbutton text="Reverse Order of Form Elements" eventHandler={reverseOrderOfFormElementsMemoized}></Memoizedbutton>
        </>
    )
}



function Button(props) { 
    // props: text, eventHandler
    // style (mosty generic and part of the props)

    return (
        <div style={{padding: "20px 0px"}}>
            <button onClick={props.eventHandler}>
                {props.text}
            </button>
        </div>
    )
}

function RTable(props) {
    return (
        <table>
            <thead>
                <tr>
                    <th>SR NO</th>
                    <th>PRODUCT</th>
                    <th>PRICE</th>
                </tr>
            </thead>
            <tbody>
                {props.data.map((item) => {
                    return (
                        <tr key={item.srno}>
                            <td>{item.srno} </td>
                            <td>{item.product} </td>
                            <td>{item.price} </td>
                        </tr>
                    )
                })}
            </tbody>
        </table>
    )
}

const Memoizedbutton = React.memo(Button);





// step-1 update the local state of the component
// step-2 react will re-render the component and update the UI with the new state value
// step-3 rect to send the state updates to backend apis

function ManualLikes() {

    const [likes, setLikes] = React.useState(0);
    const [fibLastValue, setFibLastValue] = React.useState(0);

    const inputRef = React.useRef(null);

    // useeffect is a react hook which is used to perform side effects in react components
    // takes 2 arguments
    // 1st argument is a function that contains the side effect
    // 2nd argument is an array of dependencies
    React.useEffect(() => {
        console.log("useEffect called");
    }, [likes]);


    // let likes = 0;
    // function incrementLikes() {
    //     likes++;
    //     console.log(likes);
    // }

    // state updates are always asyncrous in react, so we cannot use the updated state value immediately after calling the state update function
    function incrementLikes() {
        console.log("incrementLikes called");
        setLikes(likes + 1);
    }

    function calculateFibLastValue() {

        // logic to implement fibonacci series

        const n = inputRef.current.value;


        if (n < 0) return; 

        if (n <= 1) {
            setFibLastValue(n);
            return;
        }

        let a = 0, b = 1, c = 1;
        for (let i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        setFibLastValue(c);

    }


    return (
        <>
            <div>Likes: {likes}</div>
            <div style={{padding: "20px 20px 20px 20px", margin: "20px 20px", border: "1px solid black"}}>
                <input ref = {inputRef} type="text" placeholder="Enter fibonacci number"></input>
                <div style={{padding: "10px 0px"}}>Result: {fibLastValue}</div>
                <button onClick={calculateFibLastValue}>Calculate</button>
            </div>
            <button onClick={
                incrementLikes
            }>Increment Likes</button>

        </>
    )
}


// // version - 1 - using useEffect to uodate the backend when likes changes
// // it can accept multiple dependencies
// React.useEffect(() => {
//     console.log("useEffect called");
// }, [likes]);


// // version 2 call the useEffect only once when the component is mounted
// // eg- fetch the productList at the time of initilization of the component

// React.useEffect(() => {
//     // do something
// }, []);


// // version - 3 call the useEffext on every re-render

// React.useEffect(() => {
//     // do something
// });