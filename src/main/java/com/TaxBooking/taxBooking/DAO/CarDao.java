package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.TaxBooking.taxBooking.Domain.Car;


@Repository
public class CarDao extends GenericDao<Car> {

	public List<Car> all() {
		List<Car> list = new ArrayList<>();
		for (Car car : allObejcts()) {
			if (!car.isDeleted()) {
				list.add(car);
			}
		}
		return list;
	}
	
}
