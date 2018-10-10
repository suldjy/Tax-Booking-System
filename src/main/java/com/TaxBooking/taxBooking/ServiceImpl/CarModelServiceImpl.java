package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.CarModelDao;
import com.TaxBooking.taxBooking.Domain.CarModel;
import com.TaxBooking.taxBooking.Service.CarModelService;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class CarModelServiceImpl implements CarModelService{

	
	@Autowired
	private CarModelDao carModelDao;
	
	
	/*
	 * 
	 * method to create new  car model
	 */
	@Override
	public String save(CarModel car) {
		carModelDao.create(car);
		return "Model "+Msg.save;
	}

	/*
	 * 
	 * method to find car model by id
	 */
	@Override
	public CarModel findById(long id) {
		
		return carModelDao.findOne(id);
	}

	/*
	 * 
	 * method to list all car model
	 */
	@Override
	public List<CarModel> all() {
		
		return carModelDao.all();
	}

	
	
}
