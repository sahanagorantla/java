package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.BYTICKET;

//import com.prj.dao.Exception;

public class transaction {

	public static boolean saveTransaction(String customerName, String age, String stationIdFrom, String stationIdTo, String ticketPrice,
			String time, String travelDate) {

		try (Connection con = Database.getConnection()){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(travelDate);

			String sTransactionQuery = "INSERT INTO BYTICKET (TRAVELERNAME,FROM_STATION,TO_STATION,TIME,AGE,TICKETPRICE,DATE_OF_TRAVEL)"
					+ "VALUES ('" + customerName + "','" + stationIdFrom + "','" + stationIdTo + "','" + time + "','" + age + "','"
					+ ticketPrice + "','" + new java.sql.Date(date.getTime()) + "')";
			System.out.println(sTransactionQuery);
			PreparedStatement transaction = con.prepareStatement(sTransactionQuery);
			transaction.executeUpdate();
			return true;
		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;

	}

	public static List<BYTICKET> view() {
		List<BYTICKET> list = new ArrayList<BYTICKET>();
		try (Connection con = Database.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from byticket");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BYTICKET bean = new BYTICKET();
				bean.setId(rs.getInt("id"));
				bean.setTravelName(rs.getString("travelername"));
				bean.setStationFrom(rs.getString("from_station"));
				bean.setStationTo(rs.getString("to_station"));
				bean.setAge(rs.getString("age"));
				bean.setDate(rs.getDate("date_of_travel"));
				bean.setTime(rs.getString("time"));
				bean.setPrice(rs.getString("ticketprice"));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
