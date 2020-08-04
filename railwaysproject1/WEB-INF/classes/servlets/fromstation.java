package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Database;
import com.dao.Railway;
import com.dao.stations;


@WebServlet("/getStations")
public class fromstation extends HttpServlet {
//	public Statement stmt = null;
//
//	   Database d=new Database();
	
//	private static final Object stations1 = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List list = stations.getStations();
		System.out.println(list);
		
	}


}

