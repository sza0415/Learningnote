<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<form action="uploadservlet" method="post" enctype="multipart/form-data">
			学号：<input name="sno"><br>
			姓名：<input name="sname"><br>
			上传照片：<input type="file" name="spicture">
			<input type="submit" name="添加">
		
		</form>
</body>
</html>