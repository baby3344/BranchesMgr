package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Branches;
import service.BranchesService;

public class QueryBranchByBusinessNoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		String businessNo=request.getParameter("businessNo");
		
		BranchesService branchesService=new BranchesService();

		Branches branch=branchesService.queryBranchesByBusNo(businessNo);
		
		PrintWriter out=response.getWriter();//���������
		
		String msg=null;
		
		if(branch==null) {
			msg="false";
		}else {
			msg="true";
		}
		
		out.print("[{\"result\":\""+msg+"\"}]");
		out.flush();
		out.close();
	}
}
