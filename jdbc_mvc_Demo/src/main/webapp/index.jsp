<%@page import="org.sza.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		
		<%
		
			List<Student> students =  (List<Student>)request.getAttribute("students");
			for (Student stu : students){
		%>
			<tr>
				<td><a href="querystudentbysno?sno=<%= stu.getSno() %>"> <%= stu.getSno() %> </a></td>
				<td><%= stu.getSname() %></td>
				<td><%= stu.getSage() %></td>
				<td><%= stu.getSaddress() %></td>
				<td> <a href="deletestudent?sno=<%= stu.getSno()%>">删除</a></td>
			</tr>
		<%
			}
		%>
	</table>
	
	<a href="adduser.jsp">新增</a>
	
	<a href="querystudentsbypage?currentpage=1">首页</a>
	<a href="querystudentsbypage?currentpage=1">上一页</a>
	<a href="querystudentsbypage?currentpage=1">下一页</a>
	<a href="querystudentsbypage?currentpage=1">尾页</a>
	
	
	
</body>
</html>