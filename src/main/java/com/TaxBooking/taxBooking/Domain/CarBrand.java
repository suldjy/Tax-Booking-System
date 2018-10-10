package com.TaxBooking.taxBooking.Domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class CarBrand implements Serializable {

	
	@Autowired
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement(name = "ID")
	@JsonProperty("ID")
	@JsonIgnore
	private long id;
	
	@XmlElement(name = "NAME")
	@JsonProperty("NAME")
	private String name;
	@XmlElement(name = "DESCRIPTION")
	@JsonProperty("DESCRIPTION")
	@JsonIgnore
	private String description;
	@JsonIgnore
	private String doneBy;
	@JsonIgnore
	private String lastUpadatedBy;
	@JsonIgnore
	private Timestamp recordedDate = new Timestamp(System.currentTimeMillis());
	@JsonIgnore
	private boolean deleted = Boolean.FALSE;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	@Override
	public String toString() {
		return "CarModel [name=" + name + "]";
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
		CarBrand other = (CarBrand) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
