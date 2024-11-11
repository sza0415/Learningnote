

class Example extends React.Component{//定义一个组件类Example
    handleClick = () => {//定义一个箭头函数
        console.log(this);
    }
    render(){
        return (
            <div>
                <button onClick={this.handleClick}>click</button>    
            </div>
        );
    }
}
ReactDOM.render(
    <Example />,
    document.querySelector("div")
); 
