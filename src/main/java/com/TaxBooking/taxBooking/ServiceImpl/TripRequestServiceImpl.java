package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.TripRequestDao;
import com.TaxBooking.taxBooking.Domain.TripInfo;
import com.TaxBooking.taxBooking.Domain.Car;
import com.TaxBooking.taxBooking.Domain.CarPrice;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.EDrivingStatus;
import com.TaxBooking.taxBooking.Domain.ETripStatus;
import com.TaxBooking.taxBooking.Domain.Trip;
import com.TaxBooking.taxBooking.Service.CarPriceService;
import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Service.TripRequestService;
import com.TaxBooking.taxBooking.Utility.Location;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class TripRequestServiceImpl  implements TripRequestService{

	
	@Autowired
	private TripRequestDao tripRequestDao;
	@Autowired
	private CarPriceService carPriceService;
	@Autowired
	private DriverService driverService;
	
	
	
	/*
	 * 
	 * method to create new  trip
	 */
	
	
	@Override
	public String save(Trip tripRequest)throws Exception {
		tripRequestDao.create(tripRequest);
		Driver d=tripRequest.getDriver();
		d.seteDrivingStatus(EDrivingStatus.has_client); 
		return "Trip "+ Msg.save;
	}

	/*
	 * 
	 * method to find trip by Id
	 */
	@Override
	public Trip findById(long id)throws Exception {
		
		return tripRequestDao.findOne(id);
	}

	
	/*
	 * 
	 * method to all trips
	 */
	@Override
	public List<Trip> all()throws Exception {
		
		return tripRequestDao.allObejcts();
	}

	
	/*
	 * 
	 * method to return  available trip infos
	 */
	
	
	@Override
	public List<TripInfo> tripInfos() throws Exception {
		List<TripInfo>list=new ArrayList<TripInfo>();
		for(Trip t: all()){
			if(t.geteTripStatus().toString().equalsIgnoreCase(ETripStatus.pending.toString())){
				TripInfo c=new TripInfo();
				c.setFromLocation(t.getFrom_location());
				c.setDriver(t.getDriver().getName());
				c.setRider(t.getRider().getName());
				c.setCar_plate_no(t.getDriver().getCar().getPlateNumber());
				c.setCar_model(t.getDriver().getCar().getCarModel().getName());
				list.add(c);
			}
		}
		return list;
	}

	
	/*
	 * 
	 * method to complete trip
	 */
	@Override
	public String completeTrip(Trip tripRequest) throws Exception {
		tripRequest.seteTripStatus(ETripStatus.completed);
		tripRequestDao.update(tripRequest);
		Driver d=tripRequest.getDriver();
		d.seteDrivingStatus(EDrivingStatus.available); 
		return "Trip "+Msg.update;
	}

	
	/*
	 * 
	 * method to update trip
	 */
	@Override
	public String update(Trip tripRequest) throws Exception {
		tripRequestDao.update(tripRequest);
		return "Trip "+ Msg.update;
	}

	
	/*
	 * 
	 * method to calculate amout for trip
	 */
	@Override
	public double amount_for_trip(Trip trip) throws Exception {
		double amount=0;
		//get car user 
		Car car=trip.getDriver().getCar();
		// get how much the car is paid per 1 KM
		double amount_per_km=0;
		for(CarPrice p:carPriceService.all()){
			if(p.getCarModel().getId()==car.getCarModel().getId()){
				amount_per_km=p.getAmount();
				break;
			}
		}
		// find distance covered between from and to locations
		Location loc1 = new Location("FROM", Double.parseDouble(trip.getFrom_location().split(",")[0]),Double.parseDouble(trip.getFrom_location().split(",")[1]));
        Location loc2 = new Location("TO",   Double.parseDouble(trip.getTo_location().split(",")[0]),Double.parseDouble(trip.getTo_location().split(",")[1]));  
        double distance = loc1.distanceTo(loc2);
		
        amount=distance*amount_per_km;
		
		return amount;
	}

}
