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
            <a href="http://www.naver.com" style="margin-left:660px;"><button class="ViBu01">����</button></a>
			<a href="http://www.naver.com"><button class="ViBu01">���</button></a>
			<a href="http://www.naver.com"><button class="ViBu01">����</button></a>
			 
				<table class="Vitable01">
					<tr>
						<td width="100px;">ī�װ���</td>
						<td colspan="5">ī�װ���</td>
					</tr>
					<tr>
						<td colspan="6"><h2>�Խ��� View div�� ����</h2></td>
					</tr>
					<tr>
						<td>��  ��  ��</td>
						<td></td>
						<td colspan="3"></td>
						<td width="120px;" rowspan="2">��ۼ� : ""</td>
					</tr>
					<tr>
						<td>�ۼ�����</td>
						<td>��ȸ��:""</td>
						<td colspan="3"></td>
					</tr>
				</table>	
				<div class="Vi01">
					<div class="Vi02">
					</div>
					<button class="ViBu02"  onclick="button01_event();">�����ϱ�</button>
					<button class="ViBu02" onclick="button02_event();">�����ϱ�</button>				
				</div>
					
				<div class="Vi03">��&nbsp;&nbsp;&nbsp;��</div>
				
				<div>
					<textarea name="content" class="ViRe01">
					</textarea>
					<button class="ViBu03">�ۼ��Ϸ�</button>
				</div>		
			            
				
         </content>   
      </div>
      <footer>
      </footer>
   </div>
   
</body>
</html>