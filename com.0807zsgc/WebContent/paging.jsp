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
		<style>
		  div{
		   width:700px ;
		   height:150px ;
		  
		  }
		</style>
	</head>
	<body>
		<h1>分页展示</h1>
		<div>
		<table border="1" >
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
		 Object obj=request.getAttribute("list");
		 List<User> list=(List)obj;
		 if(null==list){
			 return;
		 }
		 Object p=request.getAttribute("pagecount");
		 int pagecount=(int)p;
		 System.out.println("得到的数据是obj："+obj);
		 //当前页码
		 int pageno=(int)request.getAttribute("pageno");
		//上一页
		 int pageup=(int)request.getAttribute("pageup");
		//下一页
		 int pagedown=(int)request.getAttribute("pagedown");
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
		         <a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a>
		      </td>
		    </tr>	
		<% 	
		}
		%>
		</table>
		</div>
		<a href="pagingServlet?pageno=1" id="shou">首页</a>&nbsp;
		<a href="pagingServlet?pageno=<%=pageup %>" id="up">上一页</a>&nbsp;
		<%
			for(int i=1;i<=pagecount;i++){
		%>
		 	<a href="pagingServlet?pageno=<%=i%>" ><%=i%>&nbsp;&nbsp;</a>
		<% 
			}
		%>
		<a href="pagingServlet?pageno=<%=pagedown%>" id="down">下一页</a>&nbsp;
		<a href="pagingServlet?pageno=<%=pagecount%>" id="wei">尾页</a>&nbsp;
		
		<script>
			var pageno="<%=pageno%>";
		    if(pageno==4){
			   var next=document.getElementById("down");
			   var wei=document.getElementById("wei");
			 	next.style.visibility="hidden"; 
			 	wei.style.visibility="hidden"; 
		    }
		    if(pageno==1){
				   var up=document.getElementById("up");
				   var shou=document.getElementById("shou");
				 	up.style.visibility="hidden"; 
				 	shou.style.visibility="hidden"; 
			    }
		    
	   </script>
		
	</body>
</html>