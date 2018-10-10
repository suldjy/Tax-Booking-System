package com.TaxBooking.taxBooking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.TaxBooking.taxBooking.Domain.Rider;

@Repository
public class RiderDao extends GenericDao<Rider> {

	public List<Rider> all() {
		List<Rider> list = new ArrayList<>();
		for (Rider rider : allObejcts()) {
			if (!rider.isDeleted()) {
				list.add(rider);
			}
		}
		return list;
	}
	
	public Rider findByName(String name){
		
		Rider rider=new Rider();
		try{
			for(Rider r:all()){
				if(r.getName().equalsIgnoreCase(name)){
					rider=r;
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return rider;
	}
}
