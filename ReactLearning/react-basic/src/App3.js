import { useEffect, useState } from "react"


function useToggle(){
    const [value,setValue] = useState(true)
    // console.log('Initial value in useToggle:', value);
    const toggleFunc = ()=>setValue(!value)

    return { 
        value , 
        toggleFunc
    }
}




function App3(){
    const {value:value_,toggleFunc} = useToggle()
    console.log(typeof value_)
    return (
        <div>
            
            {value_ && <div>this is toggle</div>}
            <button onClick={toggleFunc}>toggle</button>

        </div>
    )
}

export default App3

