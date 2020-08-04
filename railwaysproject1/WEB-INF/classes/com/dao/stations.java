package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Station;


public class stations {
	

	public static List<Station> getStations() {
		List<Station> stations1 = new ArrayList<Station>();
		try(Connection con = Database.getConnection()) {
			String stationsQuery = "select * from stations";
			
			PreparedStatement stationNames = con.prepareStatement(stationsQuery);
			ResultSet rs=stationNames.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
				Station s = new Station(Integer.parseInt(rs.getString(1)), rs.getString(2));
				stations1.add(s);
			}
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		return stations1;

}
	public static List<TransitDetails> getScheduleTime(String scheduleFrom, String scheduleTo) {
		List<TransitDetails> scheduleTime = new ArrayList<TransitDetails>();
		try(Connection con = Database.getConnection()) {
			String sTimeQuery = "SELECT TIME,SEATER,BUSSINESSCLASS,ROOM FROM SCHEDULE WHERE FROMSTATION = "+ "'"+ scheduleFrom + "'" +" AND TOSTATION =  " + "'" +scheduleTo+ "'";
			PreparedStatement stationNames = con.prepareStatement(sTimeQuery);
			ResultSet rs=stationNames.executeQuery();
			while (rs.next()) {
				TransitDetails transit = new TransitDetails();
				transit.time = rs.getString(1);
				transit.seater = rs.getString(2);
				transit.businessClass = rs.getString(3);
				transit.room = rs.getString(4);
				
				scheduleTime.add(transit);
			}
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		return scheduleTime;

	}
}
