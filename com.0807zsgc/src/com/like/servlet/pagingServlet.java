package com.like.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.like.service.UserService;
import com.like.vo.User;


@WebServlet("/pagingServlet")
public class pagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us=new UserService();
    public pagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//指定当前页码
		int pageno=1;
		String pno=request.getParameter("pageno");
		if(null != pno) {
			pageno=Integer.parseInt(pno);
		}
		
		//每页显示的条数
		int pagesize=4;
		//获得总页数
		int pagecount=us.selectCount(pagesize);
		System.out.println("总页数："+pagecount);
		request.setAttribute("pagecount", pagecount);
		//获取每页数据
		List<User> list=us.getpageUser(pageno, pagesize);
		request.setAttribute("list", list);
		int pageup=pageno>1?pageno-1:1;      //上一页
		int pagedown=pageno<pagecount?pageno+1:pagecount;//下一页
		//传递当前页
		request.setAttribute("pageno", pageno);
		request.setAttribute("pageup", pageup);
		request.setAttribute("pagedown", pagedown);
		request.getRequestDispatcher("paging.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
