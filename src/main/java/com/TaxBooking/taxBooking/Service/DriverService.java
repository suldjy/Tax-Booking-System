package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.Driver;

public interface DriverService {

	public String save(Driver driver)throws Exception;

	public Driver findById(long id)throws Exception;
	//public Driver findByReferenceNumber(String ref)throws Exception;
	public List<Driver>all()throws Exception;
	public List<Driver>avalaibleDriver()throws Exception;
	public List<Driver>driver_in_specific_distance(double number_of_km, String location)throws Exception;
	
	
}
