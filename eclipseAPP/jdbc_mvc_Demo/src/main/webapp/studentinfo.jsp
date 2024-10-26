<%@page import="org.sza.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%
		 Student stu = (Student)request.getAttribute("student");
		%>
		<form action="updatestudent">
			学号：<input type="text" value="<%= stu.getSno() %>" name="sno" readonly="readonly"/> <br>
			姓名：<input type="text" value="<%= stu.getSname() %>" name="sname"/> <br>
			年龄：<input type="text" value="<%= stu.getSage() %>" name="sage" /> <br>
			地址：<input type="text" value="<%= stu.getSaddress() %>" name="saddress" /> <br>
			<input type="submit" value="修改" /> 
			<a href="queryall">返回</a>
		</form>
		
</body>
</html>