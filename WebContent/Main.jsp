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
					<!--float position ���� ��ġ�� ��ġ�ų� ���γ� �� ���� �׷��� margin-left�� ���� ��ġ����-->	
				 
					<input id="tab1" type="radio" name="tabs" checked> 
					<label for="tab1">�̷¼�</label>
				 
					<input id="tab2" type="radio" name="tabs">
					<label for="tab2">�ڱ�Ұ���</label>
				 
				 
					<section id="content1" style="margin-bottom:20px;">
						�ٵ� ���������������� ���� �� �ְ� �Ϸ����� �̷¼� �� ����������
					</section>
				 
					<section id="content2" style="margin-bottom:20px;">
						����� �ڱ�Ұ���������? ���⵵ ���������������� ���� �� �ְ� �Ϸ�����
					</section>
				</div>	
			</content>	
		</div>
		<footer>
		</footer>
	</div>
	
</body>
</html>