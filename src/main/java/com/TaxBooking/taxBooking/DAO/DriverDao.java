package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.TaxBooking.taxBooking.Domain.Driver;


@Repository
public class DriverDao extends GenericDao<Driver>{
	
	public List<Driver> all() {
		List<Driver> list = new ArrayList<>();
		for (Driver driver : allObejcts()) {
			if (!driver.isDeleted()) {
				list.add(driver);
			}
		}
		return list;
	}
	
	

}
