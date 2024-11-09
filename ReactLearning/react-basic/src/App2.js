// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数

import { createContext, useContext, useState } from "react"

// 1. createContext方法创建一个上下文对象
const Ctx = createContext()

function Son1(){
    // 父子也是顶层和底层 都可以用Context
    const msg = useContext(Ctx)
    return  <div>{msg}</div>
}
function Son2(){
    // 3. 在底层组件 通过useContest钩子函数使用数据 参数为createContext方法创造的上下文对象
    const msg = useContext(Ctx) 
    return <div>{msg}</div>
}
function App2(){
    const app2Msg = '顶层msg'
    return (
        <div>
            {/* 2.在顶层组件 通过Provider组件提供数据 */}
            <Ctx.Provider value={app2Msg}>
                <Son1/>
                <Son2/>
            </Ctx.Provider>
 
        </div>
    )
}

export default App2