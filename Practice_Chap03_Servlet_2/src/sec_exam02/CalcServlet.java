package sec_exam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static float USD_RATE = 1210.75f;
	private static float JPY_RATE = 10.113f;
	private static float CNY_RATE = 160.30f;
	private static float GBP_RATE = 1475.75f;
	private static float EUR_RATE = 1295.75f;
	
 
    public CalcServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	

		PrintWriter writer= response.getWriter();
		
		String command= request.getParameter("command");
		String won = request.getParameter("won");
		String operator= request.getParameter("operator");
		
		if(command !=null && command.equals("calculate")) {
			String result= calculate(Float.parseFloat(won),operator);
			writer.print("<html><font size=10>변환 결과</font><br/>");
			writer.print("<font size=10>"+ result+ "</font><br/>");
			writer.print("<br><a href='calc.html'>환율계산기</a>");
			return;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private static String calculate(float won,String operator)
	{
		String result=null;
		if(operator.equals("dollar"))
		{
			result=String.format("%.6f", won/USD_RATE);
		}
		else if (operator.equals("yen")) {
			result=String.format("%.6f", won/JPY_RATE);
		}
		else if (operator.equals("yian"))
		{
			result=String.format("%.6f", won/CNY_RATE);
		}
		else if (operator.equals("found"))
		{
			result=String.format("%.6f", won/GBP_RATE);
		}
		else if (operator.equals("euro"))
		{
			result= String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}

}
