<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css");
		 @import url("<%=request.getContextPath()%>/CSS/Join.css");
			 
	</style>

	
	<script language = "javascript">
		function check(){
			if (document.form.user_id.value ==""){
				alert("아이디를 입력하세요");
				document.form.user_id.focus();
				return;
			}else if (document.form.user_pwd.value==""){
				alert("비밀번호를 입력하세요");
				document.form.user_pwd.focus();
				return;
			}else if (document.form.user_pwd2.value==""){
				alert("비밀번호 확인을 입력하세요");
				document.form.user_pwd2.focus();
				return;
			}else if (document.form.user_pwd.value != document.form.user_pwd2.value){
				alert("비밀번호가 일치하지 않습니다.");
				document.form.user_pwd2.focus();
				return;
			}else if (document.form.user_name.value==""){
				alert("이름을 입력하세요");
				document.form.user_name.focus();
				return;
		
			}else if (document.form.user_e_mail.value==""){
				alert("이메일을 입력하세요");
				document.form.user_e_mail.focus();
				return;
			}else if (document.form.user_e_mail2.value==""){
				alert("이메일을 입력하세요");
				document.form.user_e_mail.focus();
				return;
			}if(confirm("회원가입을 하시겠습니까?")){
			
		        
		        	document.form.action ="<%=request.getContextPath()%>/User/UserJoinAction.do";
		    		document.form.method = "post";		
		    		document.form.submit();	
		    }	
			return;
		}
			
	</script>
</head>
<body>
	<div class="rap">
		<jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
		
		<div class="rap2">			
			<content> 
				<div class="Jo01">
				<form name="form">
				<input type="hidden" name="idck" id="idck" value="0"> <!-- 자바스크립트에서 아이디 중복체크 알리기 위해 만듦 -->
				<input type="hidden" name="nameck" id="nameck" value="0"> <!-- 자바스크립트에서 닉네임 중복체크 알리기 위해 만듦 -->
				  <table>
					<tr>
						<td><h1 style="margin:0px 0px 40px 130px;">JOIN</h1><td>
					</tr>	
					<tr>
						<th>아 이 디</th>
					</tr>   
					<tr>
						<td><input type="text" name="user_id" id="user_id" class="Jo02"><button class="JoBu01" name="idbt" id="idbt" ">중복확인</button></td>
					</tr>   
					 
					<tr>
						<th>비밀번호</th>
					</tr>
					<tr>   
						<td><input type="password" name="user_pwd" class="Jo02"></td>
					</tr>
				  
					<tr>
						<th>비밀번호 확인</th>
					</tr>
					<tr>
						<td><input type="text" name="user_pwd2" class="Jo02"></td>
					</tr>
				  
					<tr>
						<th>닉 네 임</th>
					</tr>   
					<tr>
						<td><input type="text" name="user_name" class="Jo02"><button class="JoBu01" name="namebt" id="namebt">중복확인</button></td>
					</tr>  
					 
					<tr>
						<th>이메일</th>
					</tr>   
					<tr>
						<td>
							<input type="text" name="user_e_mail" id="user_e_mail" class="Jo03"> @ <input type="text" name="user_e_mail2" id="user_e_mail2" class="Jo03">
							<select id="email_select">
							    <option value="" selected>직접입력</option>
							    <option value="naver.com">naver.com</option>
							    <option value="daum.net">daum.net</option>
							    <option value="gmail.com">gmail.com</option>
							</select>	
						</td>	
					</tr>
					
					<tr>
						<th><input type="button" class="JoBu02" value="가 입 완 료" onclick="check();"></th>
					</tr> 
				  </table>
				  </form>
			   </div>				
			</content>	
		</div>
		
		<footer>
		</footer>
	
	</div>
</body>
</html>