package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.CarModel;
import com.TaxBooking.taxBooking.Domain.CarPrice;
import com.TaxBooking.taxBooking.Domain.Driver;

public interface CarModelService {

	public String save(CarModel car);

	public CarModel findById(long id);
	public List<CarModel>all();
}
