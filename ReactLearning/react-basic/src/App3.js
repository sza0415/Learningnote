import { useEffect, useState } from "react"



const url = 'http://geek.itheima.net/v1_0/channels' // 获取服务端数据的api



function App3(){
    return (
        <div>
            <ul>
                {list.map(item => <li key={item.id}>{item.name}</li>)}
            </ul>

        </div>
    )
}

export default App3

