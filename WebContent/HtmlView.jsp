<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css");
		 @import url("<%=request.getContextPath()%>/CSS/Nav.css");
		 @import url("<%=request.getContextPath()%>/CSS/View.css");
		
	</style>
  
</head>

<body>
   <div class="rap">
      <jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
      
      <div class="rap2">   
         <jsp:include page="TotalNav.jsp" flush="false"></jsp:include>
         
         <content> 
            <a href="http://www.naver.com" style="margin-left:660px;"><button class="ViBu01">이전</button></a>
			<a href="http://www.naver.com"><button class="ViBu01">목록</button></a>
			<a href="http://www.naver.com"><button class="ViBu01">다음</button></a>
			 
				<table class="Vitable01">
					<tr>
						<td width="100px;">카테고리명</td>
						<td colspan="5">카테고리명</td>
					</tr>
					<tr>
						<td colspan="6"><h2>게시판 View div로 보기</h2></td>
					</tr>
					<tr>
						<td>작  성  자</td>
						<td></td>
						<td colspan="3"></td>
						<td width="120px;" rowspan="2">댓글수 : ""</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td>조회수:""</td>
						<td colspan="3"></td>
					</tr>
				</table>	
				<div class="Vi01">
					<div class="Vi02">
					</div>
					<button class="ViBu02"  onclick="button01_event();">수정하기</button>
					<button class="ViBu02" onclick="button02_event();">삭제하기</button>				
				</div>
					
				<div class="Vi03">댓&nbsp;&nbsp;&nbsp;글</div>
				
				<div>
					<textarea name="content" class="ViRe01">
					</textarea>
					<button class="ViBu03">작성완료</button>
				</div>		
			            
				
         </content>   
      </div>
      <footer>
      </footer>
   </div>
   
</body>
</html>