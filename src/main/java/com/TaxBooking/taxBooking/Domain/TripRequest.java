package com.TaxBooking.taxBooking.Domain;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
 * this class is used mapping trip data from client
 */

public class TripRequest   implements Serializable{

	@Autowired
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement(name = "TRIPID")
	@JsonProperty("TRIPID")
	private long id;
	
	@XmlElement(name = "FROMLOCATION")
	@JsonProperty("FROMLOCATION")
	private String from_location;
	@XmlElement(name = "TOLOCATION")
	@JsonProperty("TOLOCATION")
	private String to_location;
	@XmlElement(name = "AMOUNT")
	@JsonProperty("AMOUNT")
	@JsonIgnore
	private double amount;
	@XmlElement(name = "CURRENCY")
	@JsonProperty("CURRENCY") 
	@Enumerated(EnumType.STRING)
	private ECurrency eCurrency;
	@Enumerated(EnumType.STRING)
	@XmlElement(name = "STATUS")
	@JsonProperty("STATUS")
	@JsonIgnore
	private ETripStatus eTripStatus;
	@XmlElement(name = "DRIVERID")
	@JsonProperty("DRIVERID")
	private long driverId;
	@XmlElement(name = "RIDERID")
	@JsonProperty("RIDERID")
	private long riderId;
	
	public String getFrom_location() {
		return from_location;
	}
	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}
	public String getTo_location() {
		return to_location;
	}
	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ECurrency geteCurrency() {
		return eCurrency;
	}
	public void seteCurrency(ECurrency eCurrency) {
		this.eCurrency = eCurrency;
	}
	public ETripStatus geteTripStatus() {
		return eTripStatus;
	}
	public void seteTripStatus(ETripStatus eTripStatus) {
		this.eTripStatus = eTripStatus;
	}
	public long getDriverId() {
		return driverId;
	}
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	public long getRiderId() {
		return riderId;
	}
	public void setRiderId(long riderId) {
		this.riderId = riderId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
