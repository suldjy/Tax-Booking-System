package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.TaxBooking.taxBooking.Domain.CarPrice;

@Repository
public class CarPriceDao extends GenericDao<CarPrice> {

	public List<CarPrice> all() {
		List<CarPrice> list = new ArrayList<>();
		for (CarPrice car : allObejcts()) {
			if (!car.isDeleted()) {
				list.add(car);
			}
		}
		return list;
	}
}
