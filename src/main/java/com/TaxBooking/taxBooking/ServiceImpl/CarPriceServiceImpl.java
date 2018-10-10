package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.CarPriceDao;
import com.TaxBooking.taxBooking.Domain.CarPrice;
import com.TaxBooking.taxBooking.Service.CarPriceService;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service

public class CarPriceServiceImpl implements CarPriceService {

	@Autowired
	private CarPriceDao carPriceDao;
	
	
	/*
	 * 
	 * method to set up new price for the car model
	 */
	
	
	@Override
	public String save(CarPrice car) {
		carPriceDao.create(car);
		return "Payment "+Msg.save;
	}

	/*
	 * 
	 * method to find price by Id
	 */
	@Override
	public CarPrice findById(long id) {
		
		return carPriceDao.findOne(id);
	}

	/*
	 * 
	 * method to list all prices for the car model
	 */
	@Override
	public List<CarPrice> all() {
		
		return carPriceDao.all();
	}

}
