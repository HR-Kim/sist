/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2017-02-20 09:37:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Beans.Ya_QnaBean;
import com.Beans.Ya_MemberBean;

public final class ya_005fqnaDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.Beans.Ya_MemberBean");
    _jspx_imports_classes.add("com.Beans.Ya_QnaBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	Ya_QnaBean bean = (Ya_QnaBean)request.getAttribute("detail");
	Ya_MemberBean user = (Ya_MemberBean)session.getAttribute("member");

      out.write("\r\n");
      out.write("<!-- Top -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../super/superTop.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"blank\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<col width=\"222\"/><col width=\"222\"/><col width=\"222\"/>\r\n");
      out.write("    \t<col width=\"222\"/><col width=\"222\"/><col width=\"222\"/>\r\n");
      out.write("    \t<col width=\"222\"/><col width=\"222\"/><col width=\"222\"/>\r\n");
      out.write("    \t<tr>\r\n");
      out.write("    \t\t<td></td>\r\n");
      out.write("    \t\t<td colspan=\"7\">________</td>\r\n");
      out.write("    \t\t<td></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("\t\t<!-- 사이드바 -->\r\n");
      out.write("            <div style=\"border-right: solid 2px #e3ebf7 ; height: 700px;\">\r\n");
      out.write("            \t<h3><b>&nbsp;&nbsp;고객센터</b></h3>\r\n");
      out.write("            \t<a href=\"noticeControl.jsp?command=list\" id=\"notice\">공지사항</a>\r\n");
      out.write("            \t\r\n");
      out.write("            \t<p></p>\r\n");
      out.write("     \t\t\t<p></p>\r\n");
      out.write("            \t<a href=");
      out.print(user.getAuth()==2? "ya_adminQnaAll.jsp" : "ya_memberQnaWrite.jsp" );
      out.write(" id=\"qna\" style=\"color: red\"><span class=\"glyphicon glyphicon-chevron-right\" style=\"color: red\"></span>1:1문의</a>\r\n");
      out.write("            \t<p></p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-10\">\r\n");
      out.write("        <!-- 본문-->\r\n");
      out.write("        <table style=\"border: 0; border-collapse:collapse; margin-top: 22px; width: 1240px; height: 100px; background-color: #ededed\">\r\n");
      out.write("        <col width=\"50\"><col width=\"400\"><col width=\"100\"><col width=\"350\">\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td style=\"border-bottom: 3px solid #a0a0a0;\"></td>\r\n");
      out.write("        \t<td colspan=\"4\" align=\"left\" valign=\"center\" style=\"border-bottom: 3px solid #a0a0a0; text-align: left;\"><h3><b>1:1문의</b></h3></td>\r\n");
      out.write("        \t<td style=\"border-bottom: 3px solid #a0a0a0;\"></td>\r\n");
      out.write("        \t<td style=\"border-bottom: 3px solid #a0a0a0;\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <table height=\"300px\" style=\"border: 0; table-layout:fixed; width: 1240px; background-color: #ededed\">\r\n");
      out.write("        <col width=\"50\"><col width=\"400\"><col width=\"100\"><col width=\"350\">\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td></td>\r\n");
      out.write("        \t<td height=\"5\" style=\"border-bottom: 1px solid #a0a0a0; text-align: left;\"><b>");
      out.print(bean.getTitle() );
      out.write("</b></td>\r\n");
      out.write("        \t<td height=\"5\" style=\"border-bottom: 1px solid #a0a0a0; text-align: left;\">");
      out.print(bean.getUpload_dt() );
      out.write("</td>\r\n");
      out.write("        \t<td></td>\t\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td></td>\r\n");
      out.write("        \t<td height=\"100\" colspan=\"2\" valign=\"top\" style=\"border-bottom: 1px solid #a0a0a0; text-align: left;\">");
      out.print(bean.getContent() );
      out.write("</td>\r\n");
      out.write("        \t<td></td>\t\r\n");
      out.write("        </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <table height=\"300px\" style=\"border: 0; table-layout:fixed; width: 1240px; background-color: #ededed\">\r\n");
      out.write("        <col width=\"50\"><col width=\"400\"><col width=\"100\"><col width=\"350\">\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td colspan=\"4\" height=\"20\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td></td>\r\n");
      out.write("        <td valign=\"top\">\r\n");
      out.write("        <input type=\"button\" id=\"del1\" class=\"form-control\" value=\"목록\" style=\"width: 100px; height: 50px\" onclick=\"history.back();\">        \r\n");
      out.write("        ");
if(user.getAuth() != 2){ 
        	if(bean.getDepth()==0){
        
      out.write("\r\n");
      out.write("    \t<form action=\"qnaControl.jsp\" name=\"f1\">\r\n");
      out.write("    \t<input type=\"hidden\" name=\"seq\" value=\"");
      out.print( bean.getSeq());
      out.write("\">\r\n");
      out.write("    \t <input type=\"hidden\" name=\"email\" value=\"");
      out.print( user.getEmail());
      out.write("\"> \r\n");
      out.write("    \t<input type=\"hidden\" name=\"command\" value=\"delete\">\r\n");
      out.write("    \t<button class=\"form-control\" style=\"width: 100px; height: 50px\" onclick=\"document.f1.submit();\">삭제하기</button>\r\n");
      out.write("    \t</form>\r\n");
      out.write("    \t");
} 
        }
    	
      out.write("\r\n");
      out.write("        ");
if(user != null){ 
      		if(user.getAuth() == 2){
      	
      out.write("\r\n");
      out.write("        <input type=\"hidden\" id=\"seq\" name=\"seq\" value=\"");
      out.print(bean.getSeq());
      out.write("\">\r\n");
      out.write("        <input type=\"hidden\" id=\"email\" name=\"email\" value=\"");
      out.print(user.getEmail());
      out.write("\">\r\n");
      out.write("        ");
if(bean.getIs_ans()==0){ 
        
      out.write("\r\n");
      out.write("        <button id=\"answer\" class=\"form-control\" style=\"width: 100px; height: 50px\">답변하기</button>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td colspan=\"4\">\r\n");
      out.write("        <div id=\"adminTable\" style=\"width: 1000px\"></div>\r\n");
      out.write("        </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
} 
      	}else{
      out.write("\r\n");
      out.write("      \t\t</td>\r\n");
      out.write("      \t\t<td></td>\r\n");
      out.write("      \t\t<td></td>\r\n");
      out.write("      \t");

      	}
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("       </div>\r\n");
      out.write("       </div>\r\n");
      out.write("       </div>\r\n");
      out.write("       <script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#answer\").click(function(){\r\n");
      out.write("\t\t$(\"#answer\").css(\"visibility\", \"hidden\");\r\n");
      out.write("\t\t$(\"#del1\").css(\"visibility\", \"hidden\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t\ttype: 'post' ,\r\n");
      out.write("\t\t\turl: './ya_qnaAdminAnswer.jsp' ,\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\"seq\" : $(\"#seq\").val(),\r\n");
      out.write("\t\t\t\t\"email\" : $(\"#email\").val()\r\n");
      out.write("\t           },\r\n");
      out.write("\t\t\tdataType : 'html' ,\r\n");
      out.write("\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t$(\"#adminTable\").html(data);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}); \r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<!--Foot -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../super/superFoot.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
