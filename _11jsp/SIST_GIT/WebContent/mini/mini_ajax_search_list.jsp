<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.khy.mini.MiniDao"%>
<%@page import="com.khy.mini.MiniBean"%> 
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="../cmn/common.jsp"></jsp:include>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	   


 	MiniDao miniDao = new MiniDao();
	//빈즈에서 가지고 올 게시물 데이터를 보관하고 있는 ArrayList 를 처리하기 위한 변수
	//ArrayList<HashMap> datas = miniDao.selectDBList();
	int page_num  = 1;
	int page_size = 10;
    int intTotalCount = 0;
    
	String strPageSize = (request.getParameter("page_size")==null || request.getParameter("page_size")=="" )?"10":request.getParameter("page_size");
	page_size = Integer.parseInt(strPageSize);
	
	String strPageNum = (request.getParameter("page_num")==null   || request.getParameter("page_num")=="")?"1":request.getParameter("page_num");
	page_num = Integer.parseInt(strPageNum);
	
	
	String search_div   = (request.getParameter("search_div")==null)?"":request.getParameter("search_div");
	String search_word  = (request.getParameter("search_word")==null)?"":request.getParameter("search_word");
	System.out.println("search_word:"+search_word);   
	ArrayList<HashMap> datas = miniDao.selectPageList(page_num, page_size, search_div, search_word);
	
    HashMap dataCnt  = null;
    
    if(datas.size()== 0) dataCnt = new HashMap();
    else dataCnt = (HashMap)datas.get(0);
    
    if(datas.size()== 0){
    	intTotalCount = 0;
    }else{
    	intTotalCount = Integer.parseInt(dataCnt.get("TOT_CNT").toString());
    }
    
    int intPageCount  = (intTotalCount/page_size);
    if(intTotalCount%page_size != 0) intPageCount++;
    
    int intRowCount = 0;  
    
	// ArrayList 를 좀더 쉽게처리하기 위한 iterator 생성.
	Iterator iter = datas.iterator();
%>

<HTML>
<HEAD><TITLE>:::MiniBook::: </TITLE>
<link href='../css/common.css' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	/*     
	$(document).ready(function() {
		
	
	     jQuery.ajax({
	           type:"GET",
	           url:"/test",
	           dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	           success : function(data) {
	                 // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	                 // TODO
	           },
	           complete : function(data) {
	                 // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	                 // TODO
	           },
	           error : function(xhr, status, error) {
	                 alert("에러발생");
	           }
	     });
	});
  */
  

	
	$( "#do_dave" ).on( "click", function() {
	   console.log( "do_dave" );
	   if(saveValid()==false)return ; 
	   if(confirm("저장 하시겠습니까 ?")) {
		   
		   var mi_id   = $("#i_mi_id").val();
		   var mi_name   = $("#i_mi_name").val();
		   var mi_date   = $("#i_mi_date").val();
		   var mi_email   = $("#i_mi_email").val();
		   var mi_passwd   = $("#i_mi_passwd").val();
		   var mi_contents   = $("#i_mi_contents").val();
		   var action        = "update";
		   if(mi_id==null || mi_id==""){
		   	action="insert";
		   	mi_id   = null;
		   }else{
			action="update";   
		   }
		   
		   
		   $.ajax({
			   type:"POST",
			   url:"mini_ajax_cont.jsp",
			   dataType:"html",
			   data:{
	               "action":  action,
	               "mi_id":  mi_id,
	               "mi_name":  mi_name,
	               "mi_date":  mi_date,
	               "mi_email":  mi_email,
	               "mi_passwd":  mi_passwd,
	               "mi_contents":  mi_contents
	           },
	           success:function(data){
	        	   var flag = ($.trim(data));
	        	   if(flag=="true"){
	        		   do_search();
	        	   }else{
	        		   alert("삭제가 실패  하였습니다.");
	        	   }
	           },
	           complete : function(data) {
	               // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	               // TODO
	        	   
	           },           
	           error:function(){
	        	   
	           }
	       });
	   }
	});
    
    $( "#do_delete" ).on( "click", function() {
 	   console.log( "do_delete" );
	   var mi_id   = $("#i_mi_id").val();
  	   console.log("mi_id:"+mi_id);
	   if(confirm("삭제하시겠습니까 ?")) {	
	   
		   $.ajax({
			   type:"POST",
			   url:"mini_ajax_cont.jsp",
			   dataType:"html",
			   data:{
	               "action":  'delete',
	               "mi_id":  mi_id
	           },
	           success:function(data){
	        	   
	        	   var flag = ($.trim(data));
	        	   if(flag=="true"){
	        		   do_search();
	        	   }else{
	        		   alert("삭제가 실패  하였습니다.");
	        	   }
	           },
	           complete : function(data) {
	               // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	               // TODO
	        	   
	           },           
	           error:function(){
	        	   
	           }
	       });
	   }
 	});
    
    
    //Table row 이벤트 감지:상세조회
    $( "#listTable" ).on( "click",'tr', function() {
    	 var mini_id   = $(this).find('#mi_id').val();
    	 var mi_passwd = $(this).find('#mi_passwd').val();
    	 
    	 console.log("mi_id:"+mini_id);
    	 console.log("mi_passwd:"+mi_passwd);
    	 
  	   $.ajax({
           type:"POST",
           url:"mini_ajax_cont.jsp",
           dataType:"html",
           data:{
               "action":  'selectOne',
               "mi_passwd": mi_passwd,
               "mi_id":  mini_id
           },
           success:function(data){
        	   
        	   var mini_board = $.parseJSON(data);
        	   $("#i_mi_id").val(mini_board.mi_id);
        	   $("#i_mi_name").val(mini_board.mini_name);
        	   $("#i_mi_date").val(mini_board.mini_date);
        	   $("#i_mi_email").val(mini_board.mini_email);
        	   $("#i_mi_passwd").val(mini_board.mini_passwd);
        	   $("#i_mi_contents").val(mini_board.mini_contents);
        	   
                },
           error:function(){
        	   
           }
       });  
    	 
	});	
    
});


function saveValid()
{
	var frm = document.frmWrite;
	/*이름 Validation*/
	if(frm.i_mi_name.value.length == 0 )
	{
		alert('이름을 입력하세요.');
		frm.i_mi_name.focus();
		return false;
	}
	
	/*Email Validation*/
	if(frm.i_mi_email.value.length == 0 )
	{
		alert('이메일을 입력하세요.');
		frm.i_mi_email.focus();
		return false;
	}		
	
	/*mi_passwd Validation*/
	if(frm.i_mi_passwd.value.length == 0 )
	{
		alert('비밀번호를 입력하세요.');
		frm.i_mi_passwd.focus();
		return false;
	}	
	
	/*mi_contents Validation*/
	if(frm.i_mi_contents.value.length == 0 )
	{
		alert('내용을 입력하세요.');
		frm.i_mi_contents.focus();
		return false;
	}	
	
	return true;
}
    /*
    	검색으로 이동
    */
	function do_search()
	{

		var frm = document.searchForm;
		var select = document.getElementById("page_size");
		var option_value = select.options[select.selectedIndex].value;

		if(option_value==""){
			return;
		}
		frm.submit();
	}
	
	/*
	 Enter Event처리
	*/
	function on_keydown()
	{		
		if(f.keyCode == 13){ 
			do_search();
		}
	}
	
	function do_goPage(page_num)
	{		
		var frm = document.searchForm;
		
		frm.page_num.value=page_num;
		console.log("page_num:"+page_num);
		frm.submit();
	}
	
</script>
</HEAD>

<BODY>
<form name="searchForm" action="mini_ajax_search_list.jsp" method="post">
<input type="hidden" name="page_num" value="" />
<center>
<H2> mini_book</H2>
<HR>
<table cellpadding=5 cellspacing=0 border="0" width=640>
	<tr>
	 	<td>
		<div id="buttonArea" align="right" width=640>
		    <input type="button" onclick="Javascript:do_search()"  onkeypress="JavaScript:on_keydown(this.form)" value="조회"/>
		</div>
		</td>
	</tr>	
</table>
<table cellpadding=5 cellspacing=0 border="0" width=640>
 <tr>
    <td align="right">
    	<select name="search_div" id="search_div" class="textfield">
    		<option value="">선택</option>
    		<option value="NAME"  <%if(search_div.equalsIgnoreCase("NAME"))out.print("selected");%> >작성자</option>
    		<option value="TITLE" <%if(search_div.equalsIgnoreCase("TITLE"))out.print("selected");%> >제목</option>
    	</select>
    	<input type="text" name="search_word" size="20" max="20" value="<%=search_word %>"  class="textfield" style="width:200px; line-height:14px;">
    </td>
 	<td align="right">페이지:
		<select name="page_size" id="page_size"  class="textfield">
			<option value="10" <%if(page_size==10)out.print("selected");%> >10</option>
			<option value="20" <%if(page_size==20)out.print("selected");%> >20</option>
			<option value="50" <%if(page_size==50)out.print("selected");%> >50</option>
		</select>
    </td>
 </tr>
</table>

<table width="640" border="0" cellspacing="1" cellpadding="0" class="table02" id="listTable">
	<tr>
		<td  class="t02" width="40" >No</td>
		<td  class="t02" width="80">작성자</td>
		<td  class="t02" height="23" >내용</td>
		<td  class="t02" height="23" width="80">생성일</td>
	</tr>
<%
	// 빈즈에서 가져온 ArrayList 에서 HashMap 을 가져와 반복해서 출력함.
	if(datas.size()>0){
	while(iter.hasNext()) {
			// ArrayList 에서 HashMap 을 가져옴. Object 로 저장되어 있기 때문에 형변환 필요
			HashMap data = (HashMap)iter.next();
%>
			  <tr>
				<td height="14" class="t02_w"><%= data.get("RNUM") %>
				 <input type="hidden" id="mi_id" name="mi_id" value="<%= data.get("mi_id") %>" />
				 <input type="hidden" id="mi_passwd" name="mi_passwd" value="<%= data.get("mi_passwd") %>" />		
				</td>
				<td class="t02_w_l"><%= data.get("mi_name") %></td>
				<td class="t02_w_l"><%= data.get("mi_contents") %></td>
				<td class="t02_w"><%= data.get("mi_date") %></td>
			  </tr>

<%
		} // end while
	}else{ // if		
%>
    <tr><td colspan="70" align="center">:::조회 데이터가 없습니다.:::</td></tr> 			
<%
	}//else
%>			
     
	</table>
<!-- Paging영역 -->	
<%if(datas.size()>0){ %>	
	<table cellpadding=5 cellspacing=0 border="0" width=640>
      <tr >
        <td colspan="6" class="list_num">
        <a href="javascript:;" onclick="do_goPage(1)"> < </a>
<%
          String pageDiv ="&nbsp;&nbsp;";
          StringBuilder pageCont=new StringBuilder();
		  for(int i=1;i<=intPageCount;i++){
			  
			  	if(i == page_num){
			  		
			  		pageCont.append("<b>"+i+"</b>");
					if(i==intPageCount)pageCont.append("");
					else pageCont.append(pageDiv);	
			  	}else{
			  		pageCont.append("<a href='javascript:;'+ "+" "+"onclick='do_goPage("+i+")'>"+i+"</a>");
			  		if(i==intPageCount)pageCont.append("");
					else pageCont.append(pageDiv);
			  	}
		  }
          out.println(pageCont.toString());

%>
            <a href="javascript:;" onclick="do_goPage('<%=intPageCount%>')"> > </a>
        </td> 
      </tr> 	
	</table>
<!--// Paging영역 -->	
<% } %>	
</form>

 <center>
 <form name="frmWrite" method="post" action="mini_cont.jsp">   
  <input type=hidden name="action" value="">
  <input type=hidden name="i_mi_id" id="i_mi_id" value="" >
              
    <table width="640" border="0" cellspacing="1" cellpadding="0" class="table02">
      <tr>
      	<td class="t02">작성자</td>
      	<td class="t02_w_l"><input type="text" name="i_mi_name" id="i_mi_name" size="20"  value="" /> </td>
      </tr>
      <tr>
      	<td class="t02">작성일</td>
      	<td class="t02_w_l"><input type="text" name="i_mi_date"   id="i_mi_date" size="20" value="" /> </td>
      </tr>      
      <tr>
        <td class="t02">e-mail</td>
        <td class="t02_w_l"><input type="text" name="i_mi_email"  id="i_mi_email"  size="20" value=""  /> </td>
      </tr>
      <tr>
        <td class="t02">비밀번호</td>
        <td class="t02_w_l"><input type="password" name="i_mi_passwd" id="i_mi_passwd" size="20" value="" /> </td>
      </tr>      
      <tr>
        <td colspan="2" class="t02"><textarea rows=5 name="i_mi_contents"  id="i_mi_contents" cols="100"></textarea></td>
      </tr>
      <tr>
      	<td colspan=2 align=center class="t02_w">
      	<input type=button value="저장"  id="do_dave">
	    <input type=button value="삭제"  id="do_delete">
	    <input type="reset" value="초기화" />
	 </td>           
    </table>
 </center>
 
</BODY>
</HTML>