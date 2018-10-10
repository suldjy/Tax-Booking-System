package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.TaxBooking.taxBooking.Domain.Trip;

@Repository
public class TripRequestDao extends GenericDao<Trip> {

	public List<Trip> all() {
		List<Trip> list = new ArrayList<>();
		for (Trip car : allObejcts()) {
			if (!car.isDeleted()) {
				list.add(car);
			}
		}
		return list;
	}
	
}
