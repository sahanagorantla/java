package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Railway;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("loginUsername");
		String password=request.getParameter("loginPassword");
		if(Railway.login(id, password)) {
			response.sendRedirect("BookReservation");
//			request.getRequestDispatcher("BookReservation").include(request, response);
			
		}
		else {
			
			request.getRequestDispatcher("index.html").include(request, response);
			/*out.println("<div style=\"position:relative,top:10%,left:70%;position: absolute;top: 64%;z-index: 99;color: white;left: 41%;\">\r\n" + 
					"invalid id or password\r\n" + 
					"</div>");
			
			out.println("</body>");
			out.println("</html>");*/
			out.close();

		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				doGet(request,response);
				System.out.println("login user name :");
				System.out.println(request.getParameter("loginUsername"));
	}
	}

