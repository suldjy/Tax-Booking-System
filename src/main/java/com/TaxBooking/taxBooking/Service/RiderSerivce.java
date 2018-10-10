package com.TaxBooking.taxBooking.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.Rider;
@Repository
public interface RiderSerivce {
	public String save(Rider rider);

	public Rider findById(long id);
	public List<Rider>all();
	public List<Driver>get_closest_drivers(Rider rider);
	public Rider findByName(String name);
}
