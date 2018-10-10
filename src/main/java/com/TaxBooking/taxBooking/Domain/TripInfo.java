package com.TaxBooking.taxBooking.Domain;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * this class is used for return data about trip to the client
 */

public class TripInfo {

	@XmlElement(name = "DRIVER")
	@JsonProperty("DRIVER")
	private String driver;
	@XmlElement(name = "RIDER")
	@JsonProperty("RIDER")
	private String rider;
	@XmlElement(name = "FROMLOCATION")
	@JsonProperty("FROMLOCATION")
	private String fromLocation;
	@XmlElement(name = "PLATENUMBER")
	@JsonProperty("PLATENUMBER")
	private String car_plate_no;
	@XmlElement(name = "CARMODEL")
	@JsonProperty("CARMODEL")
	private String car_model;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getRider() {
		return rider;
	}
	public void setRider(String rider) {
		this.rider = rider;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getCar_plate_no() {
		return car_plate_no;
	}
	public void setCar_plate_no(String car_plate_no) {
		this.car_plate_no = car_plate_no;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	
	
	
	
	
}
