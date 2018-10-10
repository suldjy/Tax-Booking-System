package com.TaxBooking.taxBooking.Domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Trip implements Serializable{
	
	
	@Autowired
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement(name = "ID")
	@JsonProperty("ID")
	private long id;
	
	@XmlElement(name = "FROMLOCATION")
	@JsonProperty("FROMLOCATION")
	private String from_location;
	@XmlElement(name = "TOLOCATION")
	@JsonProperty("TOLOCATION")
	private String to_location;
	@XmlElement(name = "AMOUNT")
	@JsonProperty("AMOUNT") 
	private double amount;
	@Enumerated(EnumType.STRING)
	@Column(length=50)  
	@XmlElement(name = "CURRENCY")
	@JsonProperty("CURRENCY") 
	private ECurrency eCurrency;
	@Enumerated(EnumType.STRING)
	@Column(length=50)  
	@XmlElement(name = "STATUS")
	@JsonProperty("STATUS") 
	@JsonIgnore
	private ETripStatus eTripStatus;
	@JsonIgnore
	private String doneBy;
	@JsonIgnore
	private String lastUpadatedBy;
	@JsonIgnore
	private Timestamp recordedDate = new Timestamp(System.currentTimeMillis());
	@JsonIgnore
	private boolean deleted = Boolean.FALSE;
	
	@OneToOne
	private Rider rider; 
	@OneToOne
	private Driver driver;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	
	public String getDoneBy() {
		return doneBy;
	}
	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}
	public String getLastUpadatedBy() {
		return lastUpadatedBy;
	}
	public void setLastUpadatedBy(String lastUpadatedBy) {
		this.lastUpadatedBy = lastUpadatedBy;
	}
	public Timestamp getRecordedDate() {
		return recordedDate;
	}
	public void setRecordedDate(Timestamp recordedDate) {
		this.recordedDate = recordedDate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TripRequest [from_location=" + from_location + ", to_location=" + to_location + ", amount=" + amount
				+ ", rider=" + rider + ", driver=" + driver + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
