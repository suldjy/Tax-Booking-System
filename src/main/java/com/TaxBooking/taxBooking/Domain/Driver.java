package com.TaxBooking.taxBooking.Domain;


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
public class Driver extends Profile{

	@Autowired
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "DRIVERID")
	@JsonProperty("DRIVERID")
	private long id;
	
	
	@Enumerated(EnumType.STRING)
	@XmlElement(name = "EDRIVINGSTATUS")
	@JsonProperty("EDRIVINGSTATUS")
	@Column(length=50) 
	@JsonIgnore
	private EDrivingStatus eDrivingStatus;
	
	
	
	@OneToOne
	private Car car;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public EDrivingStatus geteDrivingStatus() {
		return eDrivingStatus;
	}


	public void seteDrivingStatus(EDrivingStatus eDrivingStatus) {
		this.eDrivingStatus = eDrivingStatus;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	@Override
	public String toString() {
		return "Driver [id=" + id + ", car=" + car + "]";
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
		Driver other = (Driver) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
