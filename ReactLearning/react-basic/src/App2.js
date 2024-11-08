// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数
// 接收一个名为 onGetMsg 的属性，该属性是一个函数，用于将子组件的数据传递给父组件
function Son({onGetMsg}){
    const sonMsg = 'this is son msg'

    
    return  (
    <div>
        this is son
        <br/>
        <button onClick={()=>onGetMsg(sonMsg)}>send</button>
    </div>)
}
function App2(){
    const getMsg = (msg) =>{
        console.log(msg)
    }
    return (
        <div>
            <Son onGetMsg={getMsg}/>
        </div>
    )
}

export default App2