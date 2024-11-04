# JSX

JSX是JavaScript和XML（HTML）的缩写，表示在<font color=red>JS代码中编写HTML模版结构</font>，它是React编写UI的方式。

<img src="./react%E5%85%A5%E9%97%A8.assets/image-20241104170210692.png" alt="image-20241104170210692" style="zoom: 33%;" />

JSX并不是标准的JS语法，它是JS的语法扩展，浏览器本身不能识别，需要通过解析工具做解析之后才能在浏览器中运行。

在JSX中可以通过<font color=red>大括号语法{}</font>识别JavaScript中的表达式，比如常见的变量，方法的调用等。

```javascript
//  项目的根组件

const num = 1010;

function func1(){
  return "func1";
}
function App() {
  return (
    <div className  ="App">
      this is react App
      {/* 1.使用引号传递字符串 */}
      {'this is message'}

      {/* 2.识别JavaScript变量 */}
      {num}

      {/* 3.函数调用/方法调用 */}
      {func1()}
      {new Date().getDate()}

      {/* 4.使用js对象 */}
      <div style={{color:'red'}}> this is div </div>
    </div>
  );
}

export default App;
 
```

注意：if语句、switch语句、变量声明属于语句，不是表达式，不能出现在{}中。

## JSX实现列表渲染

```javascript
//  项目的根组件
const list1 = [
  {id:1001,name:'sza'},
  {id:1002,name:'myx'},
  {id:1003,name:'mjm'}
];
function App() {
  return (
    <div className  ="App">
      this is react App
      {/* 渲染列表 */}
      {/* 数组映射（.map()方法）：list1.map(item =>...) 对数组 list1 中的每个元素执行一个回调函数 */}
      {/* 对于 list1 中的每个 item（对象），回调函数会返回一个 JSX 元素 */}
      {/* 注意：在 React 中，当渲染列表时，
      为每个列表项设置一个唯一的 key 属性是很重要的，它有助于 React 更高效地更新和渲染列表。 */}
      <ul>
        {list1.map(item => <li key={item.id}> {item.name} </li>)}
      </ul>

    </div>
  );
}

export default App;
 
```

## JSX实现条件渲染

```javascript
//  项目的根组件


const isLogin = false;
function App() {
  return (
    <div className  ="App">
      {/* 逻辑与 &&  */}
      {isLogin && <span>Welcome xxx!</span>}

      {/* 三元运算 */}
      {isLogin ? <span>Welcome xxx!</span> : <span>Error!</span>}


    </div>
  );
}

export default App;
```

复杂条件渲染，自定义函数+条件语句：

```javascript
//  项目的根组件


// 文章列表 分为 无图、单图以及多图 => 0 1 2
const articleType = 0; 
function func(articleType){
  if (articleType === 0){
    return <span>无图文章</span>;
  }else if (articleType === 1){
    return <span>单图文章</span>;
  }else{
    return <span>多图文章</span>;
  }
}
function App() {
  return (
    <div className  ="App">
      {func(articleType)}
    </div>
  );
}

export default App;
```

### React事件绑定

基础事件绑定，语法：on + 事件名称 = {事件处理程序}

```javascript
//  项目的根组件
function App() {
  const handleClick = ()=>{
    console.log("被点击了");
  }

  return (
    <div className  ="App">
      <button onClick={handleClick}></button>
    </div>
  );
}

export default App;
```

使用事件对象参数，将事件对象作为实参传入

```javascript
//  项目的根组件
function App() {
  const handleClick = (e)=>{
    console.log("被点击了",e);
  }

  return (
    <div className  ="App">
      <button onClick={handleClick}></button>
    </div>
  );
}

export default App;
```

![image-20241104193751997](./react%E5%85%A5%E9%97%A8.assets/image-20241104193751997-0720461.png)

传递自定义参数，语法：事件绑定的位置改造成<font color=red>箭头函数的写法</font>，在执行handleClick实际业务函数的时候传递实参。注意：不能直接写成函数调用，因为这里的事件绑定需要的是一个<font color=red>函数引用!</font>。

```javascript
//  项目的根组件
function App() {
  const handleClick = (name)=>{
    console.log("被点击了",name);
  }

  return (
    <div className  ="App">
      <button onClick={() => handleClick("jack")} ></button>
    </div>
  );
}

export default App;
```

如果写成：

```javascript
<button onClick={handleClick("jack")} ></button>
```

在这种方式下，`handleClick("jack")`会在组件渲染时立即被调用，而不是在按钮被点击时调用。

传递事件对象参数以及自定义参数：

语法，在事件绑定的位置传递事件实参e和自定义参数。

```javascript
//  项目的根组件
function App() {
  const handleClick = (name,e)=>{
    console.log("被点击了",name,e);
  }
  const name1 = 'sza';
  return (
    <div className  ="App">
      <button onClick={(e) => handleClick(name1,e)} ></button>
    </div>
  );
}

export default App;
```

## React组件

一个组件就是用户界面的一部分，它可以有自己的逻辑和外观，组件之间可以互相嵌套，也可以复用多次。

组件化开发可以让开发者像搭积木一样构建一个完整的庞大的应用。

在React中，一个组件就是<font color=red>首字母大写的函数</font>，内部存放了组件的逻辑和视图UI，渲染组件只需要把组件当成标签书写即可。

```javascript
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
```

## useState基础使用、

