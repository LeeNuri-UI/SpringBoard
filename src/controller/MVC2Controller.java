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
			//가상 경로 추출하기
			String uri= request.getRequestURI();
			int MCV2jari = request.getContextPath().length();
			String str = uri.substring(MCV2jari);
			
			//한글 깨짐방지
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
		//response.getWriter().append("Served at: ").append(request.getContextPath()); -->생성시 생겼는데 역할을 모르겟어
	
			if(str.equals("/MVC2/HtmlList.do")){
				//게시판 리스트 불러오기
				
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
					
				//페이지 메이커에 전체 게시물 수를 담는다
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
				//글쓰기를 DB에 삽입하는 구간
				
				//request.getParameter()메소드로 내용등을 받아온다. 
				String MVC2cate = request.getParameter("MVC2cate");
				String MVC2sub = request.getParameter("MVC2sub");
				String MVC2content = request.getParameter("MVC2content");
				
				System.out.println(MVC2cate + MVC2sub + MVC2content);
				
				//세션값을 불러온다. 세션에서도 저장된 값을 받아온다
				HttpSession session = request.getSession(true);
				String user_name = (String)session.getAttribute("user_name");
				int user_num = (Integer)session.getAttribute("user_num");
				String html_ip = InetAddress.getLocalHost().getHostAddress(); // 이건 ip추적용같은데 어떤 역할인지는 잘 몰라.LocalHost인걸 보면 추적용이 맞을 듯.
				
				//MVC2Dao를 호출할 것이다.
				MVC2Dao md = new MVC2Dao();
				int value = md.MVC2Isert(MVC2cate, MVC2sub, MVC2content, user_name, user_num, html_ip);
			
				System.out.println("왔니?");		
			
				RequestDispatcher rd = request.getRequestDispatcher("/HtmlView.jsp");
				rd.forward(request, response);
			
			}else if(str.equals("/MVC2/HtmlView.do")) {
				String page = request.getParameter("page");
				if(page == null) page = "1";
				int pagex = Integer.parseInt(page);
				
				//검색
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
