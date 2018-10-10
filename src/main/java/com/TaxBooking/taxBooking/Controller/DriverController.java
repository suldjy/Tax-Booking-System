package com.TaxBooking.taxBooking.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TaxBooking.taxBooking.Service.DriverService;
import com.TaxBooking.taxBooking.Utility.Msg;
import com.TaxBooking.taxBooking.Utility.ResponseBean;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;

	/*
	 * Service to get all drivers
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllDrivers(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(driverService.all());
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
	 * Service to get all available drivers
	 */

	@RequestMapping(value = "/available", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllAvailableDrivers(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(driverService.avalaibleDriver());
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
	 * Service to get driver by ID
	 */

	@RequestMapping(value = "/byid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getDriverById(HttpServletRequest request, @PathVariable("id") String id) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(driverService.findById(Long.parseLong(id)));
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
	 * Service to get all available drivers who are in 3KM for a specific
	 * location
	 */

	@RequestMapping(value = "/by_specicic_location/{location:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getDrivers_in_three_km(HttpServletRequest request, @PathVariable("location") String location) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK"); 
					responseBean.setObject(driverService.driver_in_specific_distance(3, location));
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
