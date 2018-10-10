package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.RiderDao;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.Rider;
import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Service.RiderSerivce;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class RiderServiceImpl implements RiderSerivce{

	
	@Autowired
	private RiderDao riderDao;
	@Autowired
	private DriverService driverService;
	
	
	/*
	 * 
	 * method to create new  rider
	 */
	
	@Override
	public String save(Rider rider) {
			riderDao.create(rider);

		 return "Rider "+Msg.save;
	}

	/*
	 * 
	 * method to find rider by Id
	 */
	@Override
	public Rider findById(long id) {
		
		return riderDao.findOne(id);
	}

	/*
	 * 
	 * method to list all riders
	 */
	@Override
	public List<Rider> all() {
		
		return riderDao.all();
	}


	/*
	 * 
	 * method to get closest driver for the rider
	 */
	
	@Override
	public List<Driver> get_closest_drivers(Rider rider)  {
		
		try{
		return driverService.driver_in_specific_distance(1, rider.getCurrentLocation()).subList(0, 3); 
		}catch (Exception e) {
			return null;
		}
	}

	/*
	 * 
	 * method to find rider by name
	 */

	@Override
	public Rider findByName(String name) {
		
		return riderDao.findByName(name);
	}

}
