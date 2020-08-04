package com.bean;

import java.sql.Date;

public class BYTICKET {
	
	private int id;
	private String travelName;
	private String stationFrom;
	private String stationTo;
	private String age;
	private Date date;
	private String time;
	private int phoneNumber;
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTravelName() {
		return travelName;
	}
	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}
	public String getStationFrom() {
		return stationFrom;
	}
	public void setStationFrom(String stationFrom) {
		this.stationFrom = stationFrom;
	}
	public String getStationTo() {
		return stationTo;
	}
	public void setStationTo(String stationTo) {
		this.stationTo = stationTo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public BYTICKET(int id, String travelName, String stationFrom, String stationTo, String age, Date date, String time,
			int phoneNumber, String price) {
		super();
		this.id = id;
		this.travelName = travelName;
		this.stationFrom = stationFrom;
		this.stationTo = stationTo;
		this.age = age;
		this.date = date;
		this.time = time;
		this.phoneNumber = phoneNumber;
		this.price = price;
	}
	public BYTICKET() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BYTICKET [id=" + id + ", travelName=" + travelName + ", stationFrom=" + stationFrom + ", stationTo="
				+ stationTo + ", age=" + age + ", date=" + date + ", time=" + time + ", phoneNumber=" + phoneNumber
				+ ", price=" + price + "]";
	}
	
	
}
