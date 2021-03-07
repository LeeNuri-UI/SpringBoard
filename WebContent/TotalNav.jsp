<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<nav>   
            <div class="divN02">
               <img src="<%=request.getContextPath()%>/IMG/MainHeader.PNG" class="divN01" alt="Mainheader">
               
               <div class="divN03">
              	    자기소개란입니당<br> 아직 미작성 위에는 <br>내 사진 넣어야 겠지 <br>
                  <button class="divNB01">마이페이지</button> <!--로그인시 마이페이지 로그인안되있음 회원가입-->
                  <div class="divN04">
                     <ul><b>게시판_MVC2</b>
                        <li><a href="<%=request.getContextPath() %>/MVC2/HtmlList.do">html / css</a></li>
                        <li><a href="http://www.naver.com">자바스크립</a></li>
                        <li><a href="http://www.naver.com">제이쿼리</a></li>
                        <li><a href="http://www.naver.com">오라클 / table</a></li>
                        <li><a href="http://www.naver.com">jsp / servlet</a></li>
                     </ul>  
                  </div>      
               </div>      
            </div>
         </nav>
</body>
</html>