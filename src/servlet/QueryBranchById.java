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
		//���������󶼽���post����
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
		
		//��ȡ�����еĲ���ֵ
		int id=Integer.valueOf(request.getParameter("id"));
		
		BranchesService branchesService=new BranchesService();
		//���ò�ѯ���еķ���
		Branches branch=branchesService.queryBranchesById(id);
		
		//����ѯ������Ϣ���浽request������
		request.setAttribute("branch", branch);
		
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}
}
