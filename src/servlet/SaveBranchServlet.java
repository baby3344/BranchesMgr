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
		//������������post����
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��������ı����ʽ ��ֹ������������
		request.setCharacterEncoding("UTF-8");
		
		//������Ӧ���������Լ������ʽ
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Branches branch=new Branches();
		//��ȡ�����еĲ���ֵ
		branch.setAddress(request.getParameter("address"));
		branch.setBusinessNo(request.getParameter("businessNo"));
		branch.setCityArea(request.getParameter("cityArea"));
		branch.setName(request.getParameter("name"));
		branch.setSummary(request.getParameter("summary"));
		branch.setTelephone(request.getParameter("telephone"));
		
		BranchesService branchesService=new BranchesService();
		//�������Ӫҵ������Ϣ�ķ���
		int result=branchesService.addBranch(branch);
		
		PrintWriter out=response.getWriter();//���������
		
		if(result>0) {
			out.print("<script>");
			out.print("alert('��ӳɹ�');");
			out.print("location.href='QueryAll';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('���ʧ�ܣ����Ժ����Ի������Ա��ϵ��');");
			out.print("history.back();");
			out.print("</script>");
		}
	}
}
