<%@page import="com.like.vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h1>添加页面</h1>
     <form action="InsertServlet" method="post">
       id:<input type="text" name="id" /><br>
       username:<input type="text" name="username" /><br>
       password:<input type="text" name="password" /><br>
       createDate:<input type="date" name="createDate" /><br>
       name:<input type="text" name="name" /><br>
       phone:<input type="text" name="phone" /><br>
       address:<input type="text" name="address" /><br>
       <input type="submit" value="添加"/>
     
     </form>
	</body>
</html>