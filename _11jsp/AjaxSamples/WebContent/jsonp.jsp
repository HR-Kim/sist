<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>AJAX Sample1</h1>
<button>Ajax run</button>
<script type="text/javascript">
$(function(){
	   $("button").click(function(){
	      
	      $.ajax({
	         type: "get", // get, post 방식
	         url:'https://iwb.jp/s/js/data.jsonp', //어디서 불러올거냐능! 
	         dataType:'jsonp',
	         jsonpCallback:'android',
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