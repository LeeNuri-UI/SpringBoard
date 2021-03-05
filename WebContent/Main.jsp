<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css");
		 @import url("<%=request.getContextPath()%>/CSS/Nav.css");
		 @import url("<%=request.getContextPath()%>/CSS/Tab.css");	 
	</style>
</head>

<body>
	<div class="rap">
		<jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
		
		<div class="rap2">
			<jsp:include page="TotalNav.jsp" flush="false"></jsp:include>
			
			<content> 
				<div class="main" style="text-align:left; margin-left:220px;">
					<!--float position 등은 위치가 겹치거나 따로놀 수 있음 그래서 margin-left로 강제 위치고정-->	
				 
					<input id="tab1" type="radio" name="tabs" checked> 
					<label for="tab1">이력서</label>
				 
					<input id="tab2" type="radio" name="tabs">
					<label for="tab2">자기소개서</label>
				 
				 
					<section id="content1" style="margin-bottom:20px;">
						근데 관리자페이지에서 넣을 수 있게 하려구요 이력서 써 넣으려구요
					</section>
				 
					<section id="content2" style="margin-bottom:20px;">
						여기는 자기소개서겠지요? 여기도 관리자페이지에서 넣을 수 있게 하려구요
					</section>
				</div>	
			</content>	
		</div>
		<footer>
		</footer>
	</div>
	
</body>
</html>