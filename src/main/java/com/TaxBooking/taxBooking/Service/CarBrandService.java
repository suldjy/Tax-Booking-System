package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.CarBrand;

import com.TaxBooking.taxBooking.Domain.Driver;

public interface CarBrandService {

	public String save(CarBrand car);
	
	public CarBrand findById(long id);
	public List<CarBrand>all();
}
