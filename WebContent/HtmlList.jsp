<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "service.MVC2Vo" %>
<%@ page import = "service.MVC2Dao" %>
<%@ page import = "domain.PageMaker" %>  

<% 
	ArrayList<MVC2Vo> alist = (ArrayList<MVC2Vo>)request.getAttribute("alist"); 
	PageMaker pm = (PageMaker)request.getAttribute("pm");
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css");
		 @import url("<%=request.getContextPath()%>/CSS/Nav.css");
		 @import url("<%=request.getContextPath()%>/CSS/List.css");
	</style>
	
	<script>	
	<%
	Integer user_num = (Integer)session.getAttribute("user_num");
	String user_id = (String)session.getAttribute("user_id");
	String user_name = (String)session.getAttribute("user_name");
	%>
		 function check(){
			 if(<%=user_num%> == null || <%=user_num%> == 0){
					alert("로그인 후 이용가능합니다.");
					return;
				}
					document.form2.action ="<%=request.getContextPath()%>/MVC2/HtmlWrite.do";
					document.form2.method = "post";
					document.form2.enctype="multipart/form-data";
					document.form2.submit();
				return;
	    	}
	 </script>
	
</head>
<body>
   <div class="rap">
      <jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
      
      <div class="rap2">   
         <jsp:include page="TotalNav.jsp" flush="false"></jsp:include>
         <form name='frm' action='<%=request.getContextPath()%>/MVC2/HtmlList.do' method='post'>
         <content> 
			<div>
				<input type="text" placeholder="검색어 입력" class="serch"><button class="LiBu01">검색</button>
				
				<table>
					<tr>
						<th width="10%">No.</th>
						<th width="19%">분류</th>
						<th width="38%">제목</th>
						<th width="10%">작성자</th>
						<th width="13%">작성일</th>
						<th width="10%">조회수</th>
					</tr>
					
					<tr>
						<%
							for(MVC2Vo bv : alist){
						%>
						<td style="padding:-22px;"><b><%=bv.getMVC2_num() %></b></td>
						<td style="padding:-22px;"><b><%=bv.getMVC2_catagory() %></b></td>
						<td style="padding:-22px;"><b><% for(int i =1;i<=bv.getMVC2_re_lev();i++){
							out.print("&nbsp;&nbsp;");
							if (i == bv.getMVC2_re_lev()){
								out.print("ㄴ");
							}
						
							} %>
							<a href="<%=request.getContextPath()%>/MVC2/HtmlView.do?MVC2_num=<%=bv.getMVC2_num() %>">
							<%=bv.getMVC2_sub() %></a></b>
						</td>
						<td style="padding:-22px;"><b><%=bv.getMVC2_writer() %></b></td>
						<td style="padding:-22px;"><p style="font-size:13px;"><b><%=bv.getMVC2_date() %></b></p></td>
						<td style="padding:-22px;"><b><%=bv.getMVC2_viewcount() %></b></td>	
					</tr>
					<%} %>	
				</table>
				<form name="form2">
				<a href="http://www.naver.com"><button class="Write01" onclick="check();">글쓰기</button></a>
				</form>
				<p style="float:right; margin:12px 310px 0px 0px;"> | 1 | 2 | 3 | 4 | 5 | </p>
				
			</div>
         </content>   
         </form>
      </div>
      
      <footer>
      </footer>
   </div>
   
</body>
</html>