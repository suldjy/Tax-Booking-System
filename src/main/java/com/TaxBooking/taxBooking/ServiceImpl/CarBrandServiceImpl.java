package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.CarBrandDao;
import com.TaxBooking.taxBooking.Domain.CarBrand;
import com.TaxBooking.taxBooking.Service.CarBrandService;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class CarBrandServiceImpl implements CarBrandService {

	@Autowired
	private CarBrandDao carBrandDao;
	
	/*
	 * 
	 * method to create new  car brand
	 */
	@Override
	public String save(CarBrand car) {
		carBrandDao.create(car);
		return "Brand "+Msg.save;
	}

	/*
	 * 
	 * method to find car brand by id
	 */
	@Override
	public CarBrand findById(long id) {
		
		return carBrandDao.findOne(id);
	}

	/*
	 * 
	 * method to find all car brands
	 */
	@Override
	public List<CarBrand> all() {
		
		return carBrandDao.all();
	}

}
