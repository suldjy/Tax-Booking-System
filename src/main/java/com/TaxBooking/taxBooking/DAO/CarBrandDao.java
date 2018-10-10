package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.TaxBooking.taxBooking.Domain.CarBrand;

@Repository
public class CarBrandDao  extends GenericDao<CarBrand>{
	
	public List<CarBrand> all() {
		List<CarBrand> list = new ArrayList<>();
		for (CarBrand car : allObejcts()) {
			if (!car.isDeleted()) {
				list.add(car);
			}
		}
		return list;
	}

}
