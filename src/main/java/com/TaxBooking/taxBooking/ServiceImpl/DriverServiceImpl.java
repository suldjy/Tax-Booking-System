package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.DriverDao;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.EDrivingStatus;
import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Utility.Location;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;
	
	
	/*
	 * 
	 * method to create new  driver
	 */
	
	
	@Override
	public String save(Driver driver)throws Exception {
		
		 driverDao.create(driver);
		 return "Driver "+Msg.save;
	}

	/*
	 * 
	 * method to find driver by Id
	 */

	@Override
	public Driver findById(long id)throws Exception {
		
		return driverDao.findOne(id);
	}

	/*
	 * 
	 * method to list all drivers
	 */
	
	@Override
	public List<Driver> all()throws Exception {
		
		return driverDao.all();
	}


	/*
	 * 
	 * method to list available drivers
	 */
	@Override
	public List<Driver> avalaibleDriver()throws Exception {
		List<Driver>list=new ArrayList<Driver>();
		for(Driver d:all()){
			if(d.geteDrivingStatus().toString().equalsIgnoreCase(EDrivingStatus.available.toString())){
				list.add(d);
			}
		}
		return list;
	}



	/*@Override
	public Driver findByReferenceNumber(String ref) throws Exception {
	
		return driverDao.findByReference(ref); 
	}*/


	/*
	 * 
	 * method to find driver within specific distance according to the given location
	 */

	@Override
	public List<Driver> driver_in_specific_distance(double number_of_km, String location) throws Exception {
		List<Driver>list=new ArrayList<>();
		for(Driver d: avalaibleDriver()){
		
			Location loc1 = new Location("LOC", Double.parseDouble(location.split(",")[0]),Double.parseDouble(location.split(",")[1]));
	        Location loc2 = new Location("DRIVERLOC",   Double.parseDouble(d.getCurrentLocation().split(",")[0]),Double.parseDouble(d.getCurrentLocation().split(",")[1]));  
	        double distance = loc1.distanceTo(loc2);
	        
	        if(Location.mile_to_kilometer(distance)==number_of_km){
	        	list.add(d);
	        }
			
		}
		return list;
	}




}
