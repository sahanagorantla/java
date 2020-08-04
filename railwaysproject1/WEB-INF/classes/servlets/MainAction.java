package servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.stations;

@WebServlet("/MainAction")
public class MainAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String action = request.getParameter("action");
//		String stationFrom = request.getParameter("fromStation");
//		String stationTo = request.getParameter("toStation");
//		System.out.println(stationFrom);
//		System.out.println(stationTo);
//		if ("getTime".equals(action)) {
//		    List<String> time = stations.getScheduleTime(stationFrom, stationTo);
//		    
//		} else if ("getPrice".equals(action)) {
//		    
//			System.out.println("2");
//		}

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
