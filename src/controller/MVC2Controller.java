package controller;

import java.io.IOException;
import java.io.PrintWriter;//
import java.net.InetAddress; //
import java.util.ArrayList; //

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconn.DBconn;
import domain.PageMaker;
import domain.SearchCriteria;
import service.MVC2Dao;
import service.UserVo;
import service.MVC2Vo;


@WebServlet("/MVC2Controller")
public class MVC2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//���� ��� �����ϱ�
			String uri= request.getRequestURI();
			int MCV2jari = request.getContextPath().length();
			String str = uri.substring(MCV2jari);
			
			//�ѱ� ��������
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
		//response.getWriter().append("Served at: ").append(request.getContextPath()); -->������ ����µ� ������ �𸣰پ�
	
			if(str.equals("/MVC2/HtmlList.do")){
				//�Խ��� ����Ʈ �ҷ�����
				
				String page = request.getParameter("page");
				if(page == null) page = "1";
				int pagex = Integer.parseInt(page);
				
				String keyword = request.getParameter("keyword");
				if(keyword == null) keyword = "";
					
				String MVC2_catagory = request.getParameter("MVC2_catagory");
				if(MVC2_catagory == null) MVC2_catagory = "";
				
				SearchCriteria scri = new SearchCriteria();
				scri.setKeyword(keyword);
				scri.setPage(pagex);
				
				PageMaker pm = new PageMaker();
				pm.setScri(scri);
				
				MVC2Dao fd = new MVC2Dao();
				int cnt = fd.boardTotal(keyword);
					
				//������ ����Ŀ�� ��ü �Խù� ���� ��´�
				pm.setTotalCount(cnt);
			
				ArrayList<MVC2Vo> alist = fd.boardSelectAll(scri, MVC2_catagory);
				
				request.setAttribute("alist", alist);
				request.setAttribute("pm", pm);
				
				RequestDispatcher rd = request.getRequestDispatcher("/HtmlList.jsp");
				rd.forward(request, response);
				
			}else if(str.equals("/MVC2/HtmlWrite.do")) {
					
				RequestDispatcher rd = request.getRequestDispatcher("/HtmlWrite.jsp");
				rd.forward(request, response);
			
			}else if(str.equals("/MVC2/MVC2WriteHtmlAction.do")) {
				//�۾��⸦ DB�� �����ϴ� ����
				
				//request.getParameter()�޼ҵ�� ������� �޾ƿ´�. 
				String MVC2cate = request.getParameter("MVC2cate");
				String MVC2sub = request.getParameter("MVC2sub");
				String MVC2content = request.getParameter("MVC2content");
				
				System.out.println(MVC2cate + MVC2sub + MVC2content);
				
				//���ǰ��� �ҷ��´�. ���ǿ����� ����� ���� �޾ƿ´�
				HttpSession session = request.getSession(true);
				String user_name = (String)session.getAttribute("user_name");
				int user_num = (Integer)session.getAttribute("user_num");
				String html_ip = InetAddress.getLocalHost().getHostAddress(); // �̰� ip�����배���� � ���������� �� ����.LocalHost�ΰ� ���� �������� ���� ��.
				
				//MVC2Dao�� ȣ���� ���̴�.
				MVC2Dao md = new MVC2Dao();
				int value = md.MVC2Isert(MVC2cate, MVC2sub, MVC2content, user_name, user_num, html_ip);
			
				System.out.println("�Դ�?");		
			
				RequestDispatcher rd = request.getRequestDispatcher("/HtmlView.jsp");
				rd.forward(request, response);
			
			}else if(str.equals("/MVC2/HtmlView.do")) {
				String page = request.getParameter("page");
				if(page == null) page = "1";
				int pagex = Integer.parseInt(page);
				
				//�˻�
				String keyword = request.getParameter("keyword");
				if(keyword == null) keyword = "";
				
				String rbcategory = request.getParameter("rbcategory");
				if(rbcategory == null) rbcategory = "";
				
				SearchCriteria scri = new SearchCriteria();
				scri.setKeyword(keyword);
				scri.setPage(pagex);
				
				PageMaker pm = new PageMaker();
				pm.setScri(scri);
				
				request.setAttribute("pm", pm);
				
				RequestDispatcher rd = request.getRequestDispatcher("/HtmlView.jsp");
				rd.forward(request, response);
			}
		
		}
				

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
