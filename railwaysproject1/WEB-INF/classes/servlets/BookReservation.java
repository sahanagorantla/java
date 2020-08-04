package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Station;
import com.dao.TransitDetails;
import com.dao.stations;
import com.google.gson.Gson;



/**
 * Servlet implementation class BookReservation
 */
@WebServlet("/BookReservation")
public class BookReservation extends HttpServlet {
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("nav.html").include(request, response);
		
		out.print("<div class='container'>");
		out.print("<div class='row'>");
		out.print("<div class='offset-md-1 col-md-4 trainSearch'>");
		out.print("<div class='text-center'>");
		out.print("<img src='./rail_icon.png' alt='Rail Icon'>");
		out.print("</div>");
		out.print("<form action='Reservation' method='POST'>");
		out.print("<div>");
        out.print(" <label for='travellername' >Traveller Name</label>"
               + "<input type='text'  id='travellername' name='travllername'>");
        out.print("</div>");
        out.print("<div>");
        out.print(" <label for='travellerage' >Traveller Age</label>"
                + "<input type='text'  id='travellerage' name='travllerage'>");
        out.print("</div>");
		
		//Java script for Ajax call 
		out.print("<script type='text/javascript'>");
		out.print("function stationSelected() { var ts=document.getElementById('toStation').value; var fs=document.getElementById('fromStation').value;");
		out.print(" var xhttp = new XMLHttpRequest();"
				+ " xhttp.open('POST', `/railwaysproject/BookReservation?toStation=${ts}&fromStation=${fs}`, true);"
				+ " xhttp.setRequestHeader('Content-Type','application/json;charset=UTF-8');"
				+ " xhttp.responseType = 'json';"
				+ " xhttp.send();"
				+ " xhttp.onload = function() { var transitDetails = xhttp.response; "
				+ " var select = document.getElementById('scheduleTime');"
				+ " var length = select.options.length;"
				+ " for( i = length-1; i >= 0; i--){select.options[i] = null;}"
				+ " for(i=0; i<transitDetails.length; i++) { "
				+ " var option = document.createElement('option');" 
				+ "  option.text = transitDetails[i].time;" 
				+ "  option.value = transitDetails[i].time;"
				+ " select.appendChild(option); }"
				+ " document.getElementById('seater').value = transitDetails[0].seater;"
				+ " document.getElementById('businessClass').value = transitDetails[0].businessClass;"
				+ " document.getElementById('room').value = transitDetails[0].room;"
				+ " document.getElementById('lbl1').innerHTML = transitDetails[0].seater;"
				+ " document.getElementById('lbl2').innerHTML = transitDetails[0].businessClass;"
				+ " document.getElementById('lbl3').innerHTML = transitDetails[0].room;"
				+ " }");
		out.print("}");
		out.print("function dateSelected(event) { document.getElementById('journeyDate').value = event.target.value;");
		out.print("document.getElementById('buyTicket').disabled = false;");
		out.print("}");
		out.print("</script>");
		
		out.print("<div class='form-group'>");
		out.print("<label form='fromStation'>From Station</label>");

		
		List<Station> list = new ArrayList<Station>();
		list = stations.getStations();
		out.print("<select name='fromStation' class='form-control' id='fromStation' onChange='stationSelected()'>");
		for(int i = 0; i < list.size(); i++) {
			out.println(" <option value=" + list.get(i).name +">" + list.get(i).name + "</option>");
		}
		
		out.print("</select>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='toStation'>To Station</label> "
				+ "<select name='toStation' class='form-control' id='toStation' onChange='stationSelected()'>");
		
		
		List<Station> list2 = new ArrayList<Station>();
		list2 = stations.getStations();
		for(int i = 0; i < list2.size(); i++) {
			out.println(" <option value=" + list2.get(i).name +">" + list2.get(i).name + "</option>");
		}
		out.print("</select>");
		out.print("</div>");
		
		String stationFrom = request.getParameter("fromStation");
		String stationTo = request.getParameter("toStation");
		System.out.println(stationFrom);
		System.out.println(stationTo);
		
		
		
		out.print("<div class='form-group'>");
		out.print("<label for='scheduleTime'>Time</label>");
		List<TransitDetails> time = stations.getScheduleTime(stationFrom, stationTo);
		
		out.print("<select name='scheduleTime' class='form-control' id='scheduleTime'>");
		for(int i = 0; i < time.size(); i++) {
			out.println(" <option>" + time.get(i) + "</option>");
		}
		out.print("</select>");
		out.print("</div>");
		
		out.print("<div>");
		out.print("<label for='journeyDate'>Journey Date</label>");
		out.print("<input type='date' id='journeyDate' name='journeyDate' onChange='dateSelected(event)'>");
		out.print("</div>");
		
		out.print("<div>");
		out.print("<label for='ClassLabel'>Select Class:</label> </br>");
		out.print("<div> <label for='seater'>Seater</label> <input type='radio' id='seater' name='price' checked/> <label for='seater' id='lbl1' /></div> </br>");
		out.print("<div> <label for='businessClass'>Business Class</label> <input type='radio' id='businessClass' name='price'/><label for='businessClass' id='lbl2' /></div> </br>");
		out.print("<div> <label for='room'>Room </label> <input type='radio' id='room' name='price' /><label for='room' id='lbl3' /></div> </br>");
		out.print("</div>");
		
		out.print("<input type='submit' id='buyTicket' name='action' disabled value='Buy Ticket'/>");

		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String toStationId = request.getParameter("toStation");
		String fromStationId = request.getParameter("fromStation");
		List<TransitDetails> transits = stations.getScheduleTime(fromStationId, toStationId);
		Gson gson = new Gson();
		String timing = gson.toJson(transits);
		 
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(timing);
        out.flush();
	}
}

