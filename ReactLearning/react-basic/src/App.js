//  项目的根组件

// 自定义组件
function Button(){
  //组件内部逻辑
  return <button> click me!</button>;
}
function App() {


  return (
    <div className  ="App">
      {/* 自闭合使用自定义组件 */}
      <Button/>
      <br/>

      {/* 成对标签 使用自定义组件 */}
      <Button></Button>
      
    </div>
  );
}

export default App;