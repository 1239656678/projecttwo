package com.like.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.like.service.UserService;
import com.like.vo.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService us=new UserService();  
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取表单数据
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String createDate=request.getParameter("createDate");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		//根据id修改数据
		User user=new User(id, username, password, createDate, name, phone, address);
		int i=us.updateId(user);
		System.out.println("user=="+user);
		if(i!=0) {
			out.println("<script>window.alert('修改成功');location.href='index.jsp'</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
