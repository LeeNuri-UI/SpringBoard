<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	
	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css"); 
		 @import url("<%=request.getContextPath()%>/CSS/Login.css"); 
	</style>
	<script>   
	    function goBack() {
	        window.history.back();
	    	}
	    
	    function check(){
	    	if (document.form.user_id.value =="")	{
	    		alert("아이디를 입력하세요");
	    		document.form.user_id.focus();
	    		return;
	    	}else if (document.form.user_pwd.value==""){
	    		alert("비밀번호를 입력하세요");
	    		document.form.user_pwd.focus();
	    		return;
			}
	    		document.form.action ="<%=request.getContextPath()%>/User/UserLoginAction.do";
	    		document.form.method = "post";
	    		document.form.submit();
	    	}
    </script>
</head>
 
<body>
	<div class="rap">
		<jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
		
		<div class="rap2">			
			<content> 
				<div class="Lo01">
					<h1 style="margin: 20px 0px 20px 0px; text-align:center;"> Login</h1>
					<form name="form">
					<input type="text" placeholder="ID" maxlength="20" class="Lo02" name="user_id" id="user_id">
					<input type="text" placeholder="PW" maxlength="20" class="Lo02" name="user_pwd" id="user_pwd">
					<input type="button" class="Lo03" onclick="check();" value="Login">
					</form>
					<button class="Lo04">Find ID</button>
					<button class="Lo04">Find FW</button>
					<a href="file:///C:/Users/apfhd/Desktop/%EA%B0%9C%EC%9D%B8%EC%9A%A9/html/Join.html"><button class="Lo03">Join Us</button></a>
					
				</div>
			</content>	
		</div>
		<footer>
		</footer>
	</div>
	
</body>
</html>