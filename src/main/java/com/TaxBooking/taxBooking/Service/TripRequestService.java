package com.TaxBooking.taxBooking.Service;

import java.util.List;

import com.TaxBooking.taxBooking.Domain.TripInfo;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.Rider;
import com.TaxBooking.taxBooking.Domain.Trip;

public interface TripRequestService {

	public String save(Trip tripRequest)throws Exception;
	public String update(Trip tripRequest)throws Exception;
	public Trip findById(long id)throws Exception;
	public List<Trip>all()throws Exception;
	public List<TripInfo>tripInfos()throws Exception;
	public String completeTrip(Trip tripRequest)throws Exception;
	public double amount_for_trip(Trip trip)throws Exception;
	
}
