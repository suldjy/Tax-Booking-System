package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.Car;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.Trip;

public interface CarService {

	
	public String save(Car car)throws Exception;

	public Car findById(long id)throws Exception;
	public Car findPlateNo(String plateNo)throws Exception;
	public List<Car>all()throws Exception;
}
