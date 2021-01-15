package sec_exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/CalcServlet_1")
public class CalcServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static float USD_RATE = 1210.75f;
	private static float JPY_RATE = 10.113f;
	private static float CNY_RATE = 160.30f;
	private static float GBP_RATE = 1475.75f;
	private static float EUR_RATE = 1295.75f;
  
    public CalcServlet_1() {
        super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer= response.getWriter();

		String command= request.getParameter("command");
		String won = request.getParameter("won");
		String operator= request.getParameter("operator");
		
		if(command !=null && command.equals("calculate")) {
			String result= calculate(Float.parseFloat(won),operator);
			writer.print("<html><font size=10>��ȯ ���</font><br/>");
			writer.print("<font size=10>"+ result+ "</font><br/>");
			writer.print("<a href='calc.html'>ȯ������</a>");
			return;
			}
		writer.print("<html><title>ȯ�� ����</title>");
		writer.print("<font size=5>ȯ�� ����</font><br/>");
		writer.print("<form action='Calc' name='frmCalc' method='get'>");
		writer.print("��ȭ :&nbsp;<input type='text' name='won' size=10/>");
		writer.print("<select name='operator' >");
		writer.print("<option value='dollar' name='operator'>�޷�</option>"); 
		writer.print("<option value='yen' name='operator'>��ȭ</option>"); 
		writer.print("<option value='yian' name='operator'>����</option>"); 
		writer.print("<option value='found' name='operator'>�Ŀ��</option>"); 
		writer.print("<option value='euro' name='operator'>����</option>");
		writer.print("</select>");
		
		writer.print("<input type='hidden' name='command' value='calculate' />");
		writer.print("<input type='submit' value='Go'/>");
		writer.print("</form></html>");
		writer.close();
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
