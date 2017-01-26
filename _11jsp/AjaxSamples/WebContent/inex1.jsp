<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%!//
//%>
<%//
//%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script>
</script>
<style>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<h1>AJAX Sample1</h1>
<button>Ajax run</button>

<script type="text/javascript">
$(function(){
   $("button").click(function(){
      
      $.ajax({
         type: "get", // get, post 방식
         url:'./data.json', //어디서 불러올거냐능! 
         datatype:'json',
         success:function(data){ // 아작스가 성공하면 여기루 들어온다는것이넹!~
            $.each(data, function(i, item) {
        		$('body').prepend(i + " " + item.codename + '<br>');
         	});      
         },
         error:function(){
            alert("error");
         }
      
      });
   });
});
</script>

</body>
</html>