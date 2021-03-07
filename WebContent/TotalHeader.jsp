<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
		<header>
         <div style="position: relative;">
         	<a href="<%=request.getContextPath()%>/User/Main.do">
            <img src="<%=request.getContextPath()%>/IMG/MainLine.jpg" class="divH01" alt="Mainheader"></a>   
            <%Integer user_num = (Integer)session.getAttribute("user_num");%>
            <%String user_name = (String)session.getAttribute("user_name");%>
			<% if(session.getAttribute("user_num") == null){%>
				
				<button class="divH02" onclick="location.href='<%=request.getContextPath()%>/User/UserLogin.do'">로그인</button>&nbsp;
				<button class="divH03" onclick="location.href='<%=request.getContextPath()%>/User/UserJoin.do'">회원가입</button>&nbsp;
			
			<%}else if(session.getAttribute("user_num") != null){%>
			
			<button class="divH02"><%out.println(session.getAttribute("user_name") + "님 반갑습니다");%></button>&nbsp;
			<button class="divH03" onclick="location.href='<%=request.getContextPath()%>/User/UserLogout.do'">로그아웃</button>&nbsp;
			<%}%>
            
            <div class="divH04">
               	리누리의 코딩게시판
            </div>   
         </div>   
      </header>
</body>
</html>