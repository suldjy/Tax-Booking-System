package com.TaxBooking.taxBooking.Domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
	
	@XmlElement(name = "INVOICENUMBER")
	@JsonProperty("INVOICENUMBER")
	private String invoice_number;
	@XmlElement(name = "INVOICEDESCRIPTION")
	@JsonProperty("INVOICEDESCRIPTION")
	private String description;
	@XmlElement(name = "RIDER")
	@JsonProperty("RIDER")
	private String riderNames;
	@XmlElement(name = "DRIVER")
	@JsonProperty("DRIVER")
	private String driverNames;
	@XmlElement(name = "AMOUNT")
	@JsonProperty("AMOUNT")
	private double amount;
	@XmlElement(name = "CURRENCY")
	@JsonProperty("CURRENCY")
	private String currency;
	@XmlElement(name = "INVOICEDATE")
	@JsonProperty("INVOICEDATE")
	private String done_at;
	public String getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}
	public String getRiderNames() {
		return riderNames;
	}
	public void setRiderNames(String riderNames) {
		this.riderNames = riderNames;
	}
	public String getDriverNames() {
		return driverNames;
	}
	public void setDriverNames(String driverNames) {
		this.driverNames = driverNames;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDone_at() {
		return done_at;
	}
	public void setDone_at(String done_at) {
		this.done_at = done_at;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
	
	
	
	

}
