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
	<h1>修改页面</h1>
	<%
	   Object obj=request.getAttribute("USER");
	   User user=(User)obj;
	   System.out.println(user);
	%>
     <form action="UpdateServlet" method="post">
       id:<input type="text" name="id" value="<%=user.getId() %>" readonly="readonly"/><br>
       username:<input type="text" name="username" value="<%=user.getUsername() %>"/><br>
       password:<input type="text" name="password" value="<%=user.getPassword() %>"/><br>
       createDate:<input type="text" name="createDate" value="<%=user.getCreateDate() %>" readonly="readonly"/><br>
       name:<input type="text" name="name" value="<%=user.getName() %>"/><br>
       phone:<input type="text" name="phone" value="<%=user.getPhone() %>"/><br>
       address:<input type="text" name="address" value="<%=user.getAddress() %>"/><br>
       <input type="submit" value="修改"/>
     
     </form>
	</body>
</html>