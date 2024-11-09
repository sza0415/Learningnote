
// 项目的入口 从这里开始运行

// react必要的两个核心包
import React from 'react';
import ReactDOM from 'react-dom/client';

// 导入项目的根组件
import App from './App3';

// 把APP根组件渲染到id为root的dom节点上
// 具体为public下的index.html下的root id的dom节点
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <App />
); 


