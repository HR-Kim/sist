/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2017-01-26 05:47:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sist.BbsAccess;
import com.sist.Bbs;

public final class bbsdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.sist.Bbs");
    _jspx_imports_classes.add("com.sist.BbsAccess");
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
      out.write("<style type=\"text/css\">\r\n");
      out.write(".center{\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\twidth: 60%;\r\n");
      out.write("\tborder: 3px solid #8Ac007;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("}\r\n");
      out.write("input{\r\n");
      out.write("\tsize:50;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>bbs detail</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String seqStr = request.getParameter("seq");
	int seq = Integer.parseInt(seqStr);
	
	BbsAccess access = BbsAccess.getInstance();
	Bbs bbs = null;
	bbs = access.getBbs(seq);

      out.write("\r\n");
      out.write("<a href='logout.jsp'>로그아웃</a>\r\n");
      out.write("\r\n");
      out.write("<h1>상세글보기</h1>\r\n");
      out.write("\r\n");
      out.write("<div class=\"center\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("<col width=\"200\"><col width=\"500\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>제목</td>\r\n");
      out.write("\t\t<td><input type=\"text\" value=\"");
      out.print(bbs.getTitle() );
      out.write("\" readonly=\"readonly\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>작성자</td>\r\n");
      out.write("\t\t<td><input type=\"text\" value=\"");
      out.print(bbs.getId() );
      out.write("\" readonly=\"readonly\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>작성일</td>\r\n");
      out.write("\t\t<td><input type=\"text\" value=\"");
      out.print(bbs.getWdate() );
      out.write("\" readonly=\"readonly\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>조회수</td>\r\n");
      out.write("\t\t<td><input type=\"text\" value=\"");
      out.print(bbs.getReadcount() );
      out.write("\" readonly=\"readonly\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\ttr>\r\n");
      out.write("\t\t<td>정보</td>\r\n");
      out.write("\t\t<td><input type=\"text\" value=\"");
      out.print(bbs.getRef() );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(bbs.getDepth() );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(bbs.getStep() );
      out.write("\" readonly=\"readonly\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>내용</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<textarea rows=\"10\" cols=\"50\" readonly=\"readonly\">");
      out.print(bbs.getContent() );
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<form action=\"answer.jsp\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"seq\" value=\"");
      out.print(bbs.getSeq());
      out.write("\">\r\n");
      out.write("\t<input type=\"submit\" value=\"답글\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<a href='bbslist.jsp'>글목록</a>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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