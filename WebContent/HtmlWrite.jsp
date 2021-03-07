<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "service.MVC2Vo" %>  
<%MVC2Vo MVC2v = (MVC2Vo)request.getAttribute("MVC2v"); %>   
<!DOCTYPE html>
<head>
   <meta charset="utf-8">
   	<style type='text/css'>
		 @import url("<%=request.getContextPath()%>/CSS/Total.css");
		 @import url("<%=request.getContextPath()%>/CSS/Nav.css");
		 @import url("<%=request.getContextPath()%>/CSS/Write.css");
	</style>
	
	<script language = "javascript">
			function check(){
			if (document.form.MVC2sub.value =="")	{
				alert("제목을 입력하세요");
				document.form.MVC2sub.focus();
				return;
			}else if (document.form.MVC2content.value==""){
				alert("내용을 입력하세요");
				document.form.MVC2content.focus();
				return;
			}else if (document.form.MVC2cate.value==""){
				alert("카테고리를 선택하세요");
				document.form.MVC2cate.focus();
				return;
			}else if(confirm("작성하시겠습니까?")){
				document.form.action ="<%=request.getContextPath()%>/MVC2/MVC2WriteHtmlAction.do";
				document.form.method = "post"; //document.form.enctype="multipart/form-data"; 이거 쓰니까 컨트롤러 넘어갈 때 null값으로 입력되어 SQL에 입력되지 않음
				document.form.submit();	
		
				return;
				}
			}
			
			function goBack() {
				alert("입력한 모든 내용이 사라집니다 작성을 취소하시겠습니까?");
		        window.history.back();
		    }
	</script>		
  
</head>

<body>
   <div class="rap">
   <jsp:include page="TotalHeader.jsp" flush="false"></jsp:include>
      
      <div class="rap2">   
      <jsp:include page="TotalNav.jsp" flush="false"></jsp:include>   
         
         <content> 
         <form name="form">
            <table class="Table01">
               <tr>
                  <td width="100px"><b>작 성 자 : </b></td>
                  <th width="100px"><%out.println(session.getAttribute("user_name"));%></th>
                  <th width="100px"></th>
                  <td width="110px">카테고리 : </td>
                  <td width="370px"><select name="MVC2cate" id="MVC2cate" style="width:170px; height:26px;">
                        <option value="html / css">html / css</option> <!-- value 값에 글 안넣으면 보낼떄 값이 없어서 오류뜬다 -->
                        <option value="자바스크립">자바스크립</option>
                        <option value="제이쿼리">제이쿼리</option>
                        <option value="오라클 / table">오라클 / table</option>
                        <option value="jsp / servlet">jsp / servlet</option>
                     </select>
                  </td>
               </tr>
               <tr>
                  <td><b>글 제 목 : </b></td>
                  <td colspan="4"><input type="text" name="MVC2sub" id="MVC2sub" maxlength="40" class="text01"></td>
               </tr>
            </table>
            
            <div class="Wi01">   
                <textarea class="textarea" name="MVC2content"></textarea>
				    <!--<div class="Filebox"> 
					  <label for="ex_file">업로드</label>
					   <input type="file" name="filename" id="ex_file"> 
				   </div> -->
				<input type="file" name="filename" accept="image/*,gif/* " class="File01">   
                <button class="WiBu01" onClick="check();">작성완료</button>
                <button class="WiBu02" onClick="goBack();">취소하기</button>
            </div>  
         </form>    
         </content>   
      </div>
      
      <footer>
      </footer>
   </div>
</body>
</html>