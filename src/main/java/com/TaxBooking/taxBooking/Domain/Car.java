package com.TaxBooking.taxBooking.Domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Car implements Serializable {

	@Autowired
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "ID")
	@JsonProperty("ID")
	@JsonIgnore
	private long id;
	@XmlElement(name = "PLATENUMBER")
	@JsonProperty("PLATENUMBER")
	private String plateNumber;
	@JsonIgnore
	private String doneBy;
	@JsonIgnore
	private String lastUpadatedBy;
	@JsonIgnore
	private Timestamp recordedDate = new Timestamp(System.currentTimeMillis());
	@JsonIgnore
	private boolean deleted = Boolean.FALSE;

	@OneToOne
	private CarModel carModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + "]";
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plateNumber == null) ? 0 : plateNumber.hashCode());
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
		Car other = (Car) obj;
		if (plateNumber == null) {
			if (other.plateNumber != null)
				return false;
		} else if (!plateNumber.equals(other.plateNumber))
			return false;
		return true;
	}

}
