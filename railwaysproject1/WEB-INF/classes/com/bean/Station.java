package com.bean;


public class Station {

	public int id;
	public String name;

	public Station(int id, String name) {
		this.id = id;
		this.name = name;

	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}

