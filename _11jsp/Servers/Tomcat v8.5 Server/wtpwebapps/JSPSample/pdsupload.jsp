<%@page import="com.sist.Pds"%>
<%@page import="com.sist.PdsAccess"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>

<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pdsupload</title>
</head>
<body>
<%!
public void processFromField(FileItem item, JspWriter out) throws IOException{//추가한 jar파일안에 소속된 클래스 (JspWriter)
	String name = item.getFieldName();
	String value = "";
	
	
	try{
		value = item.getString("UTF-8");	
	}catch(Exception e){
		value = item.getString();
	}
}

public void processUploadedFile(FileItem item, String dir, JspWriter out) throws IOException{
	String fieldName = item.getFieldName();
	String fileName = item.getName();
	String contentType = item.getContentType();
	long sizeInBytes = item.getSize();
	
	System.out.println("size:" + sizeInBytes);
	
	if(sizeInBytes > 0){	//업로드한 파일이 존재하는 경우
		int idx = fileName.lastIndexOf("\\");
		if(idx == -1){
			idx = fileName.lastIndexOf("/");
		}
		fileName = fileName.substring(idx+1);
		try{
			File uploadedFile = new File(dir, fileName);
			item.write(uploadedFile);
		}catch(Exception e){
			
		}
	}
}
%>

<%
//일반폴더에 저장
//String fupload = "c:\\upload";
// Tomcat Server에 배포하고 싶을 땐
String fupload = application.getRealPath("/upload");

System.out.println("fupload:" + fupload);

String yourTempDirectory = fupload;
int yourMaxRequestSize = 100*1024*1024;
int yourMaxMemorySize = 100*1024;

String id = "";
String title = "";
String content = "";
String filename = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//Servlet 프로그램을 경유해서 파일 데이터를 취득하는 클래스
if(isMultipart){
	// item 오브젝트를 생성하는 클래스
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(yourTempDirectory));
	//setSizeThreshold 메소드에서 지정한 버퍼의 최대값을 넘었을 경우
	// 버퍼내에서 데이터를 보존하는 일시 영역을 지정한다.
	
	//item오브젝트가 저장되었던 List로 돌려준다
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize); // 파일 업로드 최대 치
	
	List<FileItem> items = upload.parseRequest(request);
	System.out.println("items:" + items);
	
	Iterator<FileItem> iter = items.iterator();
	
	while(iter.hasNext()){
		FileItem item = iter.next();
		
		// 파일 타입이 아닌 다른 폼 필드일 경우
		if(item.isFormField()){
			processFromField(item, out);
			
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");
			}else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");
			}else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}
		}else{	//파일 타입 폼 필드
			if(item.getFieldName().equals("fileload")){
				int idx = item.getName().lastIndexOf("\\");
				if(idx == -1){
					idx = item.getName().lastIndexOf("/");
				}
				filename = item.getName().substring(idx + 1);
			}
			processUploadedFile(item, fupload, out);
		}
	}
	
}else{
	System.out.println("Multipart가 아님~~~");
}

PdsAccess access = PdsAccess.getInstance();
boolean isS = access.writePds(new Pds(id, title, content, filename));


if(isS){
%>
	<script type="text/javascript">
	alert("성공");
	location.href = 'pdslist.jsp';	
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("실패");
	location.href = 'pdslist.jsp';	
	</script>
<%
}
%>

</script>
</body>
</html>























