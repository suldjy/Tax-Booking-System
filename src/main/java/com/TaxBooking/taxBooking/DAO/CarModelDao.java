package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.TaxBooking.taxBooking.Domain.CarModel;

@Repository
public class CarModelDao extends GenericDao<CarModel> {

	public List<CarModel> all() {
		List<CarModel> list = new ArrayList<>();
		for (CarModel car : allObejcts()) {
			if (!car.isDeleted()) {
				list.add(car);
			}
		}
		return list;
	}
}
