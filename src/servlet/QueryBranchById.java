package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Branches;
import service.BranchesService;

public class QueryBranchById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将所有请求都交给post处理
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求的编码格式 防止请求中文乱码
		request.setCharacterEncoding("UTF-8");
		
		//设置响应内容类型以及编码格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取请求中的参数值
		int id=Integer.valueOf(request.getParameter("id"));
		
		BranchesService branchesService=new BranchesService();
		//调用查询所有的方法
		Branches branch=branchesService.queryBranchesById(id);
		
		//将查询到的信息保存到request对象中
		request.setAttribute("branch", branch);
		
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}
}
