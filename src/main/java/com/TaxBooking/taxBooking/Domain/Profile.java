package com.TaxBooking.taxBooking.Domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@MappedSuperclass 
public class Profile implements Serializable{

	@XmlElement(name = "NAMES")
	@JsonProperty("NAMES")
	private String name;
	@XmlElement(name = "GENDER")
	@JsonProperty("GENDER")
	private String gender;
	@XmlElement(name = "PHONE")
	@JsonProperty("PHONE")
	private String phone;
	@XmlElement(name = "EMAIL")
	@JsonProperty("EMAIL")
	private String email;
	@XmlElement(name = "ADDRESS")
	@JsonProperty("ADDRESS")
	private String address;
	@XmlElement(name = "USERNAME")
	@JsonProperty("USERNAME")
	private String username;
	@JsonIgnore
	@XmlElement(name = "PASSWORD")
	@JsonProperty("PASSWORD")
	private String password;
	@XmlElement(name = "ISDEFAULT")
	@JsonProperty("ISDEFAULT")
	@JsonIgnore
	private boolean is_default=false;
	@Enumerated(EnumType.STRING)
	@XmlElement(name = "STATUS")
	@JsonProperty("STATUS") 
	@Column(length=50)  
	private EProfileStatus eProfileStatus;
	@XmlElement(name = "CURRENTLOCATION")
	@JsonProperty("CURRENTLOCATION")
	private String currentLocation;
	@JsonIgnore
	private String doneBy;
	@JsonIgnore
	private String lastUpadatedBy;
	@JsonIgnore
	private Timestamp recordedDate = new Timestamp(System.currentTimeMillis());
	@JsonIgnore
	private boolean deleted = Boolean.FALSE;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public EProfileStatus geteProfileStatus() {
		return eProfileStatus;
	}
	public void seteProfileStatus(EProfileStatus eProfileStatus) {
		this.eProfileStatus = eProfileStatus;
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
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
	
	
}
