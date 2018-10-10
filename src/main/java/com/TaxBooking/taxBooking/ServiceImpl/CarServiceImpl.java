package com.TaxBooking.taxBooking.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaxBooking.taxBooking.DAO.CarDao;
import com.TaxBooking.taxBooking.Domain.Car;
import com.TaxBooking.taxBooking.Service.CarService;
import com.TaxBooking.taxBooking.Utility.Msg;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	/*
	 * 
	 * method to create new  car 
	 */
	
	@Override
	public String save(Car car)throws Exception {
		carDao.create(car);
		return "Car "+Msg.save;
	}
	
	/*
	 * 
	 * method to find car by Id
	 */

	@Override
	public Car findById(long id)throws Exception {
		
		return carDao.findOne(id);
	}

	/*
	 * 
	 * method to list all cars
	 */
	
	@Override
	public List<Car> all()throws Exception {
		
		return carDao.all();
	}

	/*
	 * 
	 * method to find car by plateno
	 */
	
	@Override
	public Car findPlateNo(String plateNo)throws Exception {
		Car car=new Car();
		for(Car c:all()){
			if(c.getPlateNumber().equalsIgnoreCase(plateNo)){
				car=c;
				break;
			}
		}
		return car;
	}

}
