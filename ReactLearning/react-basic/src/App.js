import { useRef, useState } from 'react'
import './App.scss'
import avatar1 from './images/bozai.png'
import avatar2 from './images/bilibili.jpeg'
import lodash_ from 'lodash'
import classnames from 'classnames'
import {v4 as uuidV4} from 'uuid'
import dayjs from 'dayjs'
// 评论列表数据
const defaultList = [
  {
    rpid: 3,
    user: {
      uid: '13258165',
      avatar: avatar2,
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
      avatar: avatar2,
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
      avatar:avatar1,
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
  avatar1,
  // 用户昵称
  uname: '黑马前端',
}


// 导航 Tab 数组
const tabs = [
  { type: 'hot', text: '最热' },
  { type: 'time', text: '最新' },
]

const App = () => {
  // 1. 使用useState维护屏幕列表
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

  const [TabType, setTabType] = useState('hot')
  const handleTypeChange = (type)=>{
      setTabType(type)
      if (type === 'hot')setContentList(lodash_.orderBy(commentList,'like','desc'))
      else if (type === 'time')setContentList(lodash_.orderBy(commentList,'ctime','desc'))
  }

// 定义一个将要发布的评论 content1
  const [content1,setContent1] = useState('')

  const textareaRef = useRef(null)
  // 发布评论 这里抄一份之前的评论结构
  const handleClickPublish = ()=>{
    setContentList([...commentList,  
      {
      rpid: uuidV4(),
      user: {
        uid: '30009257',// 随机id
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

  return (
    <div className="app">

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
              <span 
              // 模板字符串是一种在 JavaScript（以及其他一些编程语言）中用于更方便地处理字符串的语法。
              // 它使用反引号（`）来包裹字符串内容，而不是单引号（'）或双引号（"）
              //  ${}是一个模板占位符，它会被里面的值所替换
              // className={`nav-item  ${TabType === item.type && 'active'}`}
              className={ classnames( 'nav-item' , { active : TabType === item.type})}

              
              key={item.type} 
              onClick={()=>handleTypeChange(item.type)}>
              {item.text}
              </span>
            ))}

          </li>
        </ul>
      </div>
      
      <div className="reply-wrap">

      <div className="box-normal">
          {/* 当前用户头像 */}
          <div className="reply-box-avatar">
            <div className="bili-avatar">
              <img className="bili-avatar-img" src={avatar1} alt="用户头像" />
            </div>
          </div>
          <div className="reply-box-wrap">
            {/* 评论框 */}
            <textarea
              value={content1}
              ref={textareaRef}
              onChange={(e) => setContent1(e.target.value)}
              className="reply-box-textarea"
              placeholder="发一条友善的评论"
            />
            {/* 发布按钮 */}
            <div className="reply-box-send">
              <div className="send-text" onClick={() => handleClickPublish()}>发布</div>
            </div>
          </div>
        </div>

        {/* 评论列表 */}
        <div className="reply-list">
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
                    {item.user.uid === loginUser.uid && (
                      <span className='delete-btn' onClick={()=>handleDel(item.user.uid)}>删除</span>
                    )}
                    
                  </div>
                </div>

              </div>
            
            </div>
          ))}
        </div>


      </div>
    </div>
  )
}

export default App