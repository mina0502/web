package sec_exam03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gugu")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GuguServlet() {
        super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer= response.getWriter();
		
		int number = Integer.parseInt(request.getParameter("number"));
		
		if(number<1 || number>9)
		{
			writer.print("<html><head></head><body>");
			writer.print("<h1> 2~9단 사이 값을 입력하세요</h1>");
			writer.print("</body></html>");
			return;
		}
		writer.print("<table boder=1 width=800 align=center>");
		writer.print("<tr align=center bgcolor='#ffff66'>");
		writer.print("<td colspan=4>"+ number+ " 단 출력 </td>");
		for (int i=1;i<10;i++)
		{
			if(i%2==0)
			{
				writer.print("<tr align=center bgcolor='#acfa58'>");
			}
			else
			{
				writer.print("<tr align=center bgcolor='#81bef7'>");
			}
			writer.print("<td width=200> "+ number + " </td>");
			writer.print("<td width=200> "+ i + " </td>");
			writer.print("<td width=200> " + number + " * " + i+ " </td>");
			writer.print("<td width=200> " + number * i +" </td>");
			writer.print("</tr>");
			
		}
		writer.print("</table>");
		writer.close();
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
