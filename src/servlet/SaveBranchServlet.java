package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Branches;
import service.BranchesService;

public class SaveBranchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将所有请求交由post处理
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
		
		Branches branch=new Branches();
		//获取请求中的参数值
		branch.setAddress(request.getParameter("address"));
		branch.setBusinessNo(request.getParameter("businessNo"));
		branch.setCityArea(request.getParameter("cityArea"));
		branch.setName(request.getParameter("name"));
		branch.setSummary(request.getParameter("summary"));
		branch.setTelephone(request.getParameter("telephone"));
		
		BranchesService branchesService=new BranchesService();
		//调用添加营业网点信息的方法
		int result=branchesService.addBranch(branch);
		
		PrintWriter out=response.getWriter();//输出流对象
		
		if(result>0) {
			out.print("<script>");
			out.print("alert('添加成功');");
			out.print("location.href='QueryAll';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('添加失败，请稍后重试或与管理员联系！');");
			out.print("history.back();");
			out.print("</script>");
		}
	}
}
