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
				
				<button class="divH02" onclick="location.href='<%=request.getContextPath()%>/User/UserLogin.do'">�α���</button>&nbsp;
				<button class="divH03" onclick="location.href='<%=request.getContextPath()%>/User/UserJoin.do'">ȸ������</button>&nbsp;
			
			<%}else if(session.getAttribute("user_num") != null){%>
			
			<button class="divH02"><%out.println(session.getAttribute("user_name") + "�� �ݰ����ϴ�");%></button>&nbsp;
			<button class="divH03" onclick="location.href='<%=request.getContextPath()%>/User/UserLogout.do'">�α׾ƿ�</button>&nbsp;
			<%}%>
            
            <div class="divH04">
               	�������� �ڵ��Խ���
            </div>   
         </div>   
      </header>
</body>
</html>