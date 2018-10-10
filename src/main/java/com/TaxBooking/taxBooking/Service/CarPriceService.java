package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.Car;
import com.TaxBooking.taxBooking.Domain.CarPrice;
import com.TaxBooking.taxBooking.Domain.Driver;

public interface CarPriceService {

	
	public String save(CarPrice car);

	public CarPrice findById(long id);
	public List<CarPrice>all();
}
