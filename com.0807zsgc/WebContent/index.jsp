<%@page import="com.like.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.like.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
	    <h5><a href="insert.jsp">添加用户</a></h5>
		<table border="1">
		    <tr>
		      <th>id</th>
		      <th>username</th>
		      <th>password</th>
		      <th>createDate</th>
		      <th>name</th>
		      <th>phone</th>
		      <th>address</th>
		      <th>操作</th>
		    </tr>
		<%
		    UserService us=new UserService();
	        List<User> list=us.getAllUser();
			for(int i=0;i<list.size();i++){
				User user=list.get(i);
		%>
			<tr>
		      <td><%=user.getId() %></td>
		      <td><%=user.getUsername() %></td>
		      <td><%=user.getPassword() %></td>
		      <td><%=user.getCreateDate() %></td>
		      <td><%=user.getName()%></td>
		      <td><%=user.getPhone() %></td>
		      <td><%=user.getAddress() %></td>
		      <td>
		         <a href="SelectServlet?id=<%=user.getId()%>">修改</a>&nbsp;&nbsp;<a href="DeleteServlet?id=<%=user.getId()%>">删除</a>
		      </td>
		    </tr>	
		<% 		
				
				
				
			}
		
		
		%>
		
		</table>
	</body>
</html>