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

```jsx
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

## useState基础使用

useState是一个React Hook函数，它允许我们向组件添加一个<font color=red>状态变量</font>，从而控制影响组件的渲染结果

本质：和普通JS变量不同的是，状态变量一旦发生变化，组件的视图UI也会跟着变化（<font color=red>数据驱动视图</font>）

```javascript
//  项目的根组件

import {useState} from 'react';

function App() {
  
  // 1. useState是一个函数，返回值是一个数组
  // 2. 数组中的第一个参数是状态变量，第二个参数是set函数用来修改状态变量
  // 3. useState的参数将作为count的初始值
  const [count , setCount] = useState(0);
  
  // 点击事件回调
  const handleClick = () =>{
    // 作用：1. 用新传入的数值修改count
    //  2。重新使用新的count渲染UI
    setCount(count + 1);
  };

  return (
    <div className  ="App">
      <button onClick={handleClick}>{count}</button>
      
    </div>
  );
}

export default App;
```

useState的状态变量不可变：

在React中，状态被认为是只读的，我们应该始终替换它而不是修改它，直接修改状态变量，不能够引发试图更新

```javascript
  const handleClick = () =>{
    // 作用：1. 用新传入的数值修改count
    //  2。重新使用新的count渲染UI

    // 这里直接对count进行修改 无法引发视图更新
    count++;
    // setCount(count + 1);
  };
```

修改复杂对象状态：

对于对象类型的状态变量，应该始终传给set方法一个<font color=red>全新的对象</font>来进行修改。

```javascript
//  项目的根组件

import {useState} from 'react';

function App() {

  const [form,setForm] = useState({name:'jack'});

  // {...form, name: 'sza' }使用了扩展运算符（...）来复制现有的form对象，
  // 并在新对象中更新name属性为sza
  const handleClick = () =>{
    setForm({
      ...form,
      name:'sza'
    }
    );
  }

  return (
    <div className  ="App">

      <button onClick={handleClick}>{form.name}</button>
      
    </div>
  );
}

export default App;
```

## 基础样式控制

行内样式（不推荐）

```javascript
//  项目的根组件
function App() {

  return (
    <div className  ="App">
    <span style={{color:'red',fontSize:'50px'}}>行内样式1</span>
      
    </div>
  );
}

export default App;
```

```javascript
//  项目的根组件

const style1 = {
  color:'red',
  fontSize:'30px'
}

function App() {

  return (
    <div className  ="App">
    <span style={style1}>行内样式2</span>
    
    </div>
  );
}

export default App;
```

class类名控制

```javascript
/* index.css */
.foo{
    color:red;
    font-size:16px
}
```

```javascript
//  项目的根组件
import './index.css'
function App() {

  return (
    <div className  ="App">
    <span className='foo'>行内样式2</span>
    
    </div>
  );
}

export default App;
```

# Day1 评论案例

评论列表数据和当前登录用户数据

```javascript
// 评论列表数据
const defaultList = [
  {
    rpid: 3,
    user: {
      uid: '13258165',
      avatar: '',
      uname: '周杰伦',
    },
    content: '哎哟，不错哦',
    ctime: '10-18 08:15',
    like: 89,
  },
  {
    rpid: 2,
    user: {
      uid: '36080105',
      avatar: '',
      uname: '许嵩',
    },
    content: '我寻你千百度 日出到迟暮',
    ctime: '11-13 11:29',
    like: 88,
  },
  {
    rpid: 1,
    user: {
      uid: '30009257',
      avatar,
      uname: '前端',
    },
    content: '学前端就',
    ctime: '10-19 09:00',
    like: 66,
  },
]
// 当前登录用户信息
const loginUser = {
  // 用户id
  uid: '30009257',
  // 用户头像
  avatar,
  // 用户昵称
  uname: '黑马前端',
}
```



## 渲染评论列表

核心思路：

- 使用useState维护评论列表

```javascript
  // 1. 使用useState维护屏幕列表
  const [commentList , setContentList] = useState(defaultList)
```

- 使用<font color=yellow>map方法</font>对列表数据进行遍历渲染（别忘了加key）

```jsx
          {/* 评论项 */}  
          {/* 2. 使用map方法对数据列表进行遍历渲染 */}
          {commentList.map(item => (
            <div className="reply-item" key={item.rpid}>

              {/* 头像 */}
              <div className="root-reply-avatar">
                <div className="bili-avatar">
                  <img className="bili-avatar-img" src={item.user.avatar} />
                </div>
              </div>

              <div className="content-wrap">
                <div className="user-info">
                  <div className="user-name">{item.user.uname}</div>
                </div>

                <div className="root-reply">
                  <span className="reply-content">{item.content}</span>
                  <div className="reply-info">
                    <span className="reply-time">{item.ctime}</span>
                    <span className="reply-time">点赞数:{item.like}</span>
                  </div>
                </div>

              </div>
            
            </div>
            
          ))}
```

## 实现评论删除

需求：

1. 只有自己的评论才可以显示删除按钮
1. 点击删除按钮，删除当前评论，列表中不再显示

核心思路

- 删除显示 => 条件渲染

```javascript
                    {item.user.uid === loginUser.uid && (
                      <span className='delete-btn'>删除</span>
                    )}
```

- 删除功能 => 拿到当前项id，以id为条件对评论列表做filter过滤 

```javascript
                    {item.user.uid === loginUser.uid && (
                      <span className='delete-btn' onClick={()=>handleDel(item.user.uid)}>删除</span>
                    )}
```

```javascript
const [commentList , setContentList] = useState(defaultList)  
const handleDel = (user_id) => {
    // 对commentList做过滤处理
    /*
    filter()方法的作用：
    在 JavaScript 中，数组的filter()方法用于创建一个新数组，
    这个新数组包含通过给定函数测试的原始数组中的所有元素。
    它会遍历原始数组中的每一个元素，并将每个元素传入提供的函数进行判断。
    如果函数返回true，则该元素会被包含在新数组中；如果返回false，则该元素会被排除。
    */
    setContentList(commentList.filter(item => item.user.uid!==user_id))
  }
```

## 渲染Tab + 点击高亮实现

需求：点击哪个tab项，哪个做高亮处理

核心思路：

点击谁，就把谁的type(你也可以取名其他的，独一无二的标识)记录下来，然后和遍历时的每一项type做匹配，谁匹配到就设置负责高亮的类名

- 准备一个Tab数组

```javascript
// 导航 Tab 数组
const tabs = [
  { type: 'hot', text: '最热' },
  { type: 'time', text: '最新' },
]
```

-   使用map方法对tab数组进行遍历渲染

```jsx
      {/* 导航 Tab */}
      <div className="reply-navigation">
        <ul className="nav-bar">
          <li className="nav-title">
            <span className="nav-title-text">评论</span>
            {/* 评论数量 */}
            <span className="total-reply">{10}</span>
          </li>

          {/* 使用map进行列表数据遍历渲染 需要加上key */}
          <li className="nav-sort">
            {tabs.map(item =>(
              <span className='nav-item' key={item.type}>{item.text}</span>
            ))}

          </li>
        </ul>
      </div>
```

-  tab切换功能，点击谁就把谁的type记录下来，然后在map遍历渲染时增加条件匹配

```javascript
  const [TabType, setTabType] = useState('hot')
  const handleTypeChange = (type)=>{
      setTabType(type)
  }
```

```jsx
          {/* 使用map进行列表数据遍历渲染 需要加上key */}
          <li className="nav-sort">
            {tabs.map(item =>(
              <span 
              // 模板字符串是一种在 JavaScript（以及其他一些编程语言）中用于更方便地处理字符串的语法。
              // 它使用反引号（`）来包裹字符串内容，而不是单引号（'）或双引号（"）
              //  ${}是一个模板占位符，它会被里面的值所替换
              className={`nav-item ${TabType === item.type && 'active'}`}
              key={item.type} 
              onClick={()=>handleTypeChange(item.type)}>
              {item.text}
              </span>
            ))}

          </li>
```

## 评论排序功能

需求：

点击最新，评论列表按照创建事件倒序排列（新的在前），点击最热按照点赞数排序（多的在前）

核心思路：

<font color=yellow>把评论列表状态数据进行不同的排序处理，当成新值传给set函数重新渲染视图UI</font>

```javascript
  const handleTypeChange = (type)=>{
      setTabType(type)
      if (type === 'hot')setContentList(lodash_.orderBy(commentList,'like','desc'))
      else if (type === 'time')setContentList(lodash_.orderBy(commentList,'ctime','desc'))
  }
```

使用了一个三方库lodash进行排序 orderBy( 列表 , 字段 , 排序方式 )

## classnames优化类名控制

classnames是一个简单的JS库，可以非常方便地通过<font color=yellow>条件动态控制class类名的显示</font>

![image-20241105150008173](./react%E5%85%A5%E9%97%A8.assets/image-20241105150008173.png)

这里的class类名是通过字符串的拼接而成，不够直观，并且容易出错。

```shell
npm install classnames
```

![image-20241105151341159](./react%E5%85%A5%E9%97%A8.assets/image-20241105151341159.png)

# Day2

## 受控表单绑定

使用React组件的状态（useState）控制表单的状态

![image-20241108152142388](./react%E5%85%A5%E9%97%A8.assets/image-20241108152142388.png)

- 准备一个React状态值

```javascript
const [value1,setValue1] = useState('')
```

- 通过value属性绑定状态，通过onChange属性绑定状态同步的函数

```jsx
      {value1}
      <input value={value1} onChange={(e)=>setValue1(e.target.value)} type='text'>
      </input>
```

## React中获取Dom

在React组件中获取/操作DOM，需要使用useRef hook函数，分为两步：

- 使用useRef创建ref对象，并与JSX绑定

```javascript
// useRef生成ref对象，绑定到dom标签身上
  const inputRef = useRef(null)
```

```javascript
      {/* 使用ref绑定 */}
      <input ref={inputRef} value="sza"></input>
```

- 在dom可用时，通过.current获取dom对象

```javascript
  const onShow = ()=>{
    // dom可用时，ref.current获取dom
    console.log(inputRef.current.value);
  }
```

```jsx
      {/* 点击会打印sza的字样 */}
      <button onClick={onShow}>打印dom</button>
```

## B站评论 发表评论
![image-20241108160410674](./react%E5%85%A5%E9%97%A8.assets/image-20241108160410674.png)

获取评论内容：

```javascript
// 定义一个将要发布的评论 content1
  const [content1,setContent1] = useState('')
```

```jsx
            <textarea
              value={content1}
              // ref={textareaRef}
              onChange={(e) => setContent1(e.target.value)}
              className="reply-box-textarea"
              placeholder="发一条友善的评论"
            />
```

点击发布按钮发布评论：

```jsx
            <div className="reply-box-send">
              <div className="send-text" onClick={() => handleClickPublish()}>发布</div>
            </div>
```

```javascript
// 定义一个将要发布的评论 content1
  const [content1,setContent1] = useState('')


  // 发布评论 这里抄一份之前的评论结构
  const handleClickPublish = ()=>{
    setContentList([...commentList,  {
      rpid: 10086,
      user: {
        uid: '30009257',
        avatar:avatar1,
        uname: '前端',
      },
      content: content1,
      ctime: '10-19 09:00',
      like: 667,
    },])
  }
```

## 独一id和时间处理

```javascript
  {
    rpid: 1,
    user: {
      uid: '30009257',
      avatar:avatar1,
      uname: '前端',
    },
    content: '学前端就',
    ctime: '10-19 09:00',
    like: 66,
  },
```

评论的信息 的rpid和cime应该重新设置，分别使用uuid和dayjs

```javascript
import {v4 as uuidV4} from 'uuid'
import dayjs from 'dayjs'

  // 发布评论 这里抄一份之前的评论结构
  const handleClickPublish = ()=>{
    setContentList([...commentList,  
      {
      rpid: 10086,
      user: {
        uid: uuidV4(),
        avatar:avatar1,
        uname: '前端',
      },
      content: content1,
      ctime: dayjs(new Date()).format('MM-DD hh:mm'),
      like: 667,
    }
  ])
  }
```

## b站评论案例 清空内容并重新聚焦

- 清空内容，将input框的value属性设为空字符串

```javascript
  // 发布评论 这里抄一份之前的评论结构
  const handleClickPublish = ()=>{
    setContentList([...commentList,  
      {
      rpid: 10086,
      user: {
        uid: uuidv4(),// 随机id
        avatar:avatar1,
        uname: '前端',
      },
      content: content1,
      ctime: dayjs(new Date()).format('MM-DD hh:mm'),
      like: 667,
    }
  ])
    setContent1('')
  }
```



- 重新聚焦：拿到input的dom元素，调用focus方法

```javascript
  const textareaRef = useRef(null)
  // 发布评论 这里抄一份之前的评论结构
  const handleClickPublish = ()=>{
    setContentList([...commentList,  
      {
      rpid: 10086,
      user: {
        uid: uuidv4(),// 随机id
        avatar:avatar1,
        uname: '前端',
      },
      content: content1,
      ctime: dayjs(new Date()).format('MM-DD hh:mm'),
      like: 667,
    }
  ])
    setContent1('')
    // 先使用 ref绑定 聚焦
    textareaRef.current.focus()
  }
```

## 父子通信 父传子 父组件传参给子组件

```javascript
// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数
function Son(props){
    // props：对象里面包含了父组件中传递过来的所有数据
    
    console.log(props);
    
    return   <div>this is Son {props.fuck}-----{props.a}</div>
}
function App2(){
    const var1 = "this is father variable"
    const var2 = "this is father variable2"
    return (
        <div>
            <Son name={var1} a={var2}/>
        </div>
    )
}

export default App2
```

传过来的props Object

![image-20241108203749454](./react%E5%85%A5%E9%97%A8.assets/image-20241108203749454.png)

- props可传递任意的数据：数字、字符串、布尔值、数组、对象、函数、JSX

```javascript
function App2(){
    const var1 = "this is father variable"
    const var2 = "this is father variable2"
    return (
        <div>
            <Son 
            name={var1} 
            a={var2}
            isTrue={false}
            list={['Vue','React']}
            obj={{name:'sza'}}
            cb={()=>{console.log('something else')}}
            children = {<span>what?</span>}
            />
        </div>
    )
}

export default App2
```

![image-20241108204342415](./react%E5%85%A5%E9%97%A8.assets/image-20241108204342415.png)

- props是只读对象

子组件<font color=yellow>只能读取props中的数据，不能直接进行修改</font>，父组件的数据只能由父组件修改

特殊的prop children

场景：当我们把内容嵌套在自组件标签当中时，父组件会自动在名为children的prop属性中接受改内容

```javascript
// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数
function Son(props){
    // props：对象里面包含了父组件中传递过来的所有数据

    console.log(props);
    //  默认都是children 
    return   <div>this is Son {props.children[0]} ----  {props.children[1]} ----  {props.children[2]}</div>
}
function App2(){
    const var1 = "this is father variable1"
    const var2 = "this is father variable2"
    return (
        <div>
            <Son>
                {var1}
                {var2}
                <span> this is span 3</span>
            </Son>
        </div>
    )
}

export default App2
```

![image-20241108210126390](./react%E5%85%A5%E9%97%A8.assets/image-20241108210126390.png)

## 父子通信 子传父

![image-20241108210421185](./react%E5%85%A5%E9%97%A8.assets/image-20241108210421185.png)
核心思路是：在子组件中调用父组件中的函数并传递参数

![image-20241108210556251](./react%E5%85%A5%E9%97%A8.assets/image-20241108210556251.png)

子组件调用父组件传的带参函数，子组件在赋值参数的时候，就会传递给了父组件的函数，相当于是子传父

- 在返回的 JSX 结构中，包含一个文本内容 “this is son” 和一个按钮。当按钮被点击时，会调用 `onGetMsg` 函数并将 `sonMsg` 作为参数传递给父组件。

```javascript
// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数
function Son(props){
    const sonMsg = 'this is son msg'

    
    return  (
    <div>
        this is son
        <br/>
        <button onClick={()=>props.onGetMsg(sonMsg)}>send</button>
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
```

```javascript
// 父传子
// 1. 父组件传递数据 自组件标签身上绑定属性
// 2. 自组件接受数据 props的参数
// // 接收一个名为 onGetMsg 的属性，该属性是一个函数，用于将子组件的数据传递给父组件
function Son({onGetMsg}){// onGetMsg必须与<Son onGetMsg={getMsg}/>这里的属性一致
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
```

