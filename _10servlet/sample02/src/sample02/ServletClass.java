package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class ServletClass extends HttpServlet {
   
   int count = 0;

   @Override                   //요청               //응답 -> 서버로부터 받은DATA를 뿌려줌 
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        // request는 사용하는 함수가 많고 response는 하나정도만 알면된다.
      System.out.println("doGet");
      resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
      PrintWriter out = resp.getWriter();
      StringBuffer sb =new StringBuffer(); // 버퍼는 저장공간 
      sb.append("<html>");
      sb.append("<head>");
      sb.append("<title>HelloWorld</title>");
      sb.append("<body>");
      sb.append("<h1>ServletClass Get!</h1>");
      
      count++;
      sb.append("<p>방문 인원수 : ");
      sb.append(count);
      sb.append("</p>");
      
      sb.append("<form action=\"yj\" method=\"post\">");
      sb.append("<input type=\"submit\" value=\"post로 송신\">");
      sb.append("</form>");
      
      sb.append("</body>");
      sb.append("</html>");
      
      out.println(sb); //같은 함수라서 동적할당 안해줘도된다.
      out.close();
      
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // TODO Auto-generated method stub
      System.out.println("doPost");
      resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
      PrintWriter out = resp.getWriter();
      StringBuffer sb =new StringBuffer(); // 버퍼는 저장공간 
      sb.append("<html>");
      sb.append("<head>");
      sb.append("<title>HelloWorld</title>");
      sb.append("<body>");
      sb.append("<h1>ServletClass Post!</h1>");
      
      sb.append("<form action=\"yj\" method=\"get\">");
      sb.append("<input type=\"submit\" value=\"get으로 송신\">");
      sb.append("</form>");
      
      sb.append("</body>");
      sb.append("</html>");
      
      out.println(sb); //같은 함수라서 동적할당 안해줘도된다.
      out.close();
   }
   
   

}