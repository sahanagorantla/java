package servlets;

import com.dao.transaction;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reservation")
		
public class Reservation extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    transaction.saveTransaction(request.getParameter("travllername"),
	    		request.getParameter("travllerage"),
	    		request.getParameter("fromStation"),
	    		request.getParameter("toStation"),
	    		request.getParameter("price"),
	    		request.getParameter("scheduleTime"),
	    		request.getParameter("journeyDate")
	    		);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("nav.html").include(request, response);
		
		out.print("<div class='container'>");
		out.print("<div class='row'>");
		out.print("<div class='offset-md-1 col-md-4 trainSearch'>");
		out.print("<div class='text-center'>");
		out.print("</div>");
		out.print("<div>");
        out.print(" <label for='Message' >YOUR TRANSACTION IS SUCSSEFUL</label> </br>" );
        out.print("<a  href='ViewReservation'>Click here to View Reservations</a>");
        out.print("</div>");

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request,response);
}
}