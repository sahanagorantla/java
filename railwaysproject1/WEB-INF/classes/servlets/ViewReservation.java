package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BYTICKET;
import com.dao.transaction;

//import com.prj.servlet.PrintWriter;

/**
 * Servlet implementation class ViewReservation
 */
@WebServlet("/ViewReservation")
public class ViewReservation extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    request.getRequestDispatcher("nav.html").include(request, response);
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println(" <link rel='stylesheet' href='resources/css/styles.css'>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\r\n" + "");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">\r\n");
		
		List<BYTICKET> list = transaction.view();
		
		out.println("<table class='table table-bordered table-hover' style='padding-top:70px;' >");
		out.println(" <tr class=\"bg-light textColor\"><th scope=\"col\">Id</th>\r\n" + 
				"                    <th scope=\"col\">Name</th>\r\n" + 
				"                    <th scope=\"col\">From Station</th>\r\n" + 
				"                    <th scope=\"col\">To Station</th>\r\n" + 
				"                    <th scope=\"col\">Age</th>\r\n" + 
				"                    <th scope=\"col\">Price</th>\r\n" + 
				"                    <th scope=\"col\">Time</th>\r\n" + 
				"                    <th scope=\"col\">Number</th>\r\n" + 
				"                    <th scope=\"col\">Date</th></tr>");
		for(BYTICKET bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getTravelName()+"</td><td>"+bean.getStationFrom()+"</td><td>"+bean.getStationTo()+"</td><td>"+bean.getAge()+"</td>"
					+ "<td>"+bean.getPrice()+"</td><td>"+bean.getTime()+"</td>"
					+ "<td>"+bean.getPhoneNumber()+"</td><td>"+bean.getDate()+"</td>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
