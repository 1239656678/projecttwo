package com.like.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.like.service.UserService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us=new UserService();
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码方式
		response.setContentType("text/html;charset=utf-8");
		//获取用户要删除的id
		PrintWriter out=response.getWriter();
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		int i=us.deleteId(id);
		System.out.println("删除的结果为："+i);
		if(i!=0) {
			out.write("<script>window.alert('删除成功');location.href='index.jsp'</script>");
			return;
		}else {
		    response.sendRedirect("index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
