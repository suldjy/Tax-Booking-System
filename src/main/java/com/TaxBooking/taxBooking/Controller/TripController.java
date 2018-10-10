package com.TaxBooking.taxBooking.Controller;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TaxBooking.taxBooking.Domain.ETripStatus;
import com.TaxBooking.taxBooking.Domain.Invoice;
import com.TaxBooking.taxBooking.Domain.TripRequest;
import com.TaxBooking.taxBooking.Domain.Trip;
import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Service.RiderSerivce;
import com.TaxBooking.taxBooking.Service.TripRequestService;
import com.TaxBooking.taxBooking.Utility.Location;
import com.TaxBooking.taxBooking.Utility.Msg;
import com.TaxBooking.taxBooking.Utility.ResponseBean;


@RestController
@RequestMapping("/trips")
public class TripController {
	
	
	@Autowired
	private TripRequestService tripRequestService;
	@Autowired
	private RiderSerivce riderSerivce;
	@Autowired
	private DriverService driverService;

	/*
	 * Service to get all active trips
	 */

	@RequestMapping(value = "/activetrips", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAlActiveTrips(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(tripRequestService.tripInfos());
				} else {
					responseBean.setCode(Msg.INCORRECT_TOKEN);
					responseBean.setDescription("INCCORECT TOKEN ");
					responseBean.setObject(null);
				}

			} else {

				responseBean.setCode(Msg.TOKEN_NOT_FOUND);
				responseBean.setDescription(" TOKEN NOT FOUND ");
				responseBean.setObject(null);

			}
		} catch (Exception e) {
			responseBean.setCode(Msg.ERROR_CODE);
			responseBean.setDescription("SOMETHING WENT WRONG TRY AGAIN ");
			responseBean.setObject(null);
		}

		return responseBean;
	}
	
	
	
	/*
	 * Service to create new trip
	 */

	@RequestMapping(value="/newtrip", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean create_trip(@RequestBody TripRequest trip,HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {
					Trip r=new Trip();
					r.setFrom_location(trip.getFrom_location());
					r.setTo_location(trip.getTo_location()); 
					r.setAmount(trip.getAmount());
					r.seteCurrency(trip.geteCurrency());
					r.seteTripStatus(ETripStatus.pending);
					r.setRider(riderSerivce.findById(trip.getRiderId())); 
					r.setDriver(driverService.findById(trip.getDriverId())); 
					String message=tripRequestService.save(r);
					if(message.contains(Msg.save)){
					trip.setId(r.getId());
					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(trip);
					}else{
						responseBean.setCode(Msg.ERROR_CODE);
						responseBean.setDescription("SOMETHING WENT WRONG TRY AGAIN ");
						responseBean.setObject(null);
					}
				} else {
					responseBean.setCode(Msg.INCORRECT_TOKEN);
					responseBean.setDescription("INCCORECT TOKEN ");
					responseBean.setObject(null);
				}

			} else {

				responseBean.setCode(Msg.TOKEN_NOT_FOUND);
				responseBean.setDescription(" TOKEN NOT FOUND ");
				responseBean.setObject(null);

			}
		} catch (Exception e) {
			responseBean.setCode(Msg.ERROR_CODE);
			responseBean.setDescription("SOMETHING WENT WRONG TRY AGAIN ");
			responseBean.setObject(null);
		}

		return responseBean;
	}
	
	
	/*
	 * Service to create new trip
	 */

	@RequestMapping(value="/completetrip", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean complete_trip(@RequestBody TripRequest trip,HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {
					Trip r=tripRequestService.findById(trip.getId());
				
					r.setTo_location(trip.getTo_location()); 
					r.setAmount(tripRequestService.amount_for_trip(r)); 
					r.seteCurrency(trip.geteCurrency());
									
					String message=tripRequestService.completeTrip(r);
					if(message.contains(Msg.update)){
					Invoice invoice=new Invoice();	
					invoice.setInvoice_number("INV00"+(r.getId()+1));
					invoice.setDescription("Invoice for trip that covered "+new DecimalFormat("###.##").format(Location.distanceCovered(r.getFrom_location(), r.getTo_location()))+" KM"); 
					invoice.setDriverNames(r.getDriver().getName());
					invoice.setRiderNames(r.getRider().getName());
					invoice.setAmount(r.getAmount());
					invoice.setCurrency(r.geteCurrency().toString());
					Timestamp date=new Timestamp(new Date().getTime());
					invoice.setDone_at(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(date));
					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(invoice);
					}else{
						responseBean.setCode(Msg.ERROR_CODE);
						responseBean.setDescription("SOMETHING WENT WRONG TRY AGAIN ");
						responseBean.setObject(null);
					}
				} else {
					responseBean.setCode(Msg.INCORRECT_TOKEN);
					responseBean.setDescription("INCCORECT TOKEN ");
					responseBean.setObject(null);
				}

			} else {

				responseBean.setCode(Msg.TOKEN_NOT_FOUND);
				responseBean.setDescription(" TOKEN NOT FOUND ");
				responseBean.setObject(null);

			}
		} catch (Exception e) {
			responseBean.setCode(Msg.ERROR_CODE);
			responseBean.setDescription("SOMETHING WENT WRONG TRY AGAIN ");
			responseBean.setObject(null);
		}

		return responseBean;
	}
	
	
	
	

	
}
