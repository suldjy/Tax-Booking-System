package com.TaxBooking.taxBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaxBooking.taxBooking.Domain.Car;
import com.TaxBooking.taxBooking.Domain.CarBrand;
import com.TaxBooking.taxBooking.Domain.CarModel;
import com.TaxBooking.taxBooking.Domain.CarPrice;
import com.TaxBooking.taxBooking.Domain.Driver;
import com.TaxBooking.taxBooking.Domain.ECurrency;
import com.TaxBooking.taxBooking.Domain.EDrivingStatus;
import com.TaxBooking.taxBooking.Domain.EProfileStatus;
import com.TaxBooking.taxBooking.Domain.Rider;
import com.TaxBooking.taxBooking.Service.CarBrandService;
import com.TaxBooking.taxBooking.Service.CarModelService;
import com.TaxBooking.taxBooking.Service.CarPriceService;
import com.TaxBooking.taxBooking.Service.CarService;
import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Service.RiderSerivce;
import com.TaxBooking.taxBooking.Utility.Location;

@RestController
public class ApplicationController {

	@Autowired
	private RiderSerivce riderSerivce;
	@Autowired
	private CarBrandService carBrandService;
	
	@Autowired
	private CarModelService carModelService;
	
	@Autowired
	private CarPriceService carPriceService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private DriverService driverService;
	/*
	 * @RequestMapping(value="/testing") public String testing(){
	 * 
	 * Location loc1 = new Location("CHIC", -1.9390464,30.060544); Location loc2
	 * = new Location("KCT", -1.9438095,30.0573838); double distance =
	 * loc1.distanceTo(loc2); return
	 * "Distance :"+Location.mile_to_kilometer(distance)+"KM from "+loc1+" to "
	 * +loc2; }
	 */

	@RequestMapping(value = "/initialize") 
	public String testing()throws Exception {
		if(riderSerivce.all().isEmpty()){
		// add 3 rider
		for (int i = 1; i <= 3; i++) {
			Rider rider = new Rider();
			rider.setName("RIDER " + i);
			rider.setAddress("KIGALI");
			rider.seteProfileStatus(EProfileStatus.active);
			rider.setPhone("250788888888");
			rider.setPassword("xxxx");
			rider.setUsername(rider.getPhone());
			rider.setIs_default(false);
			if(i==1){
			rider.setCurrentLocation("-1.9390464,30.060544");
			}else if(i==2){
				rider.setCurrentLocation("-1.9690464,30.060644");
			}else{
				rider.setCurrentLocation("-1.9290464,30.060591");	
			}
			
			if (i % 2 == 0) {
				rider.setGender("MALE");
			} else {
				rider.setGender("FEMALE");
			}
			riderSerivce.save(rider);
		}
		// add 2 car brand, their car models, car and prices
		CarBrand b=new CarBrand();
		b.setName("AUDI");
		b.setDescription("It's AUDI");
		carBrandService.save(b);
		
		CarModel m=new CarModel();
		m.setName("Audi Q5");
		m.setDescription("It's Audi Q5");
		m.setCarBrand(b);
		carModelService.save(m);
		
		CarPrice p=new CarPrice();
		p.setAmount(5000);
		p.setCarModel(m);
		p.seteCurrency(ECurrency.RWF); 
		carPriceService.save(p);
		
		
		Car c=new Car();
		c.setCarModel(m);
		c.setPlateNumber("RAD115P");
		carService.save(c);
		
		
		CarModel m1=new CarModel();
		m1.setName("Audi TT");
		m1.setDescription("It's Audi TT");
		m1.setCarBrand(b);
		carModelService.save(m1);
		
		CarPrice p1=new CarPrice();
		p1.setAmount(10000);
		p1.setCarModel(m1);
		p1.seteCurrency(ECurrency.RWF); 
		carPriceService.save(p1);
		
		Car c1=new Car();
		c1.setCarModel(m1);
		c1.setPlateNumber("RAC221B");
		carService.save(c1);
		
		
		CarBrand b1=new CarBrand();
		b1.setName("TOYOTA");
		b1.setDescription("It's TOYTA");
		carBrandService.save(b1);
		
		CarModel m2=new CarModel();
		m2.setName("AVENSIS VERSO");
		m2.setDescription("It's AVENSIS VERSO");
		m2.setCarBrand(b1);
		carModelService.save(m2);
		
		CarPrice p2=new CarPrice();
		p2.setAmount(2500);
		p2.setCarModel(m2);
		p2.seteCurrency(ECurrency.RWF); 
		carPriceService.save(p2);
		
		Car c2=new Car();
		c2.setCarModel(m2);
		c2.setPlateNumber("RAC918Z");
		carService.save(c2);
		
		CarModel m3=new CarModel();
		m3.setName("CARINA E");
		m3.setDescription("It's CARINA E");
		m3.setCarBrand(b1);
		carModelService.save(m3);
		
		CarPrice p3=new CarPrice();
		p3.setAmount(1500);
		p3.setCarModel(m3);
		p3.seteCurrency(ECurrency.RWF); 
		carPriceService.save(p3);
		
		
		Car c3=new Car();
		c3.setCarModel(m3);
		c3.setPlateNumber("RAB743D");
		carService.save(c3);
		
		// add 3 driver
		
		for (int i = 1; i <= 3; i++) {
			Driver driver = new Driver();
			driver.setName("DRIVER " + i);
			driver.setAddress("KIGALI");
			driver.seteProfileStatus(EProfileStatus.active);
			driver.seteDrivingStatus(EDrivingStatus.available);
			driver.setPassword("xxxx");
			
			driver.setIs_default(false);
			if(i==1){
			driver.setCurrentLocation("-1.9390464,30.060544");
			driver.setPhone("250782888888");
			driver.setCar(carService.findPlateNo("RAB743D"));
			}else if(i==2){
				driver.setCurrentLocation("-1.9590464,30.060545");
				driver.setPhone("250783888888");
				driver.setCar(carService.findPlateNo("RAD115P"));
			}else{
				driver.setPhone("250784888888");
				driver.setCurrentLocation("-1.9190464,30.070545");
				driver.setCar(carService.findPlateNo("RAC221B")); 
			}
			if (i % 2 == 0) {
				driver.setGender("MALE");
			} else {
				driver.setGender("FEMALE");
			}
			driver.setUsername(driver.getPhone()); 
			driverService.save(driver);
		}
		}
		
		
		
		return "OK";
	}

}
