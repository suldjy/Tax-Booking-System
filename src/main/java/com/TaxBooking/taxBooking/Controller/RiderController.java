package com.TaxBooking.taxBooking.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TaxBooking.taxBooking.Service.RiderSerivce;
import com.TaxBooking.taxBooking.Utility.Msg;
import com.TaxBooking.taxBooking.Utility.ResponseBean;

@RestController
@RequestMapping("/riders")
public class RiderController {

	@Autowired
	private RiderSerivce riderSerivce;

	/*
	 * Service to get all riders
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllRiders(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(riderSerivce.all());
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
	 * Service to get rider by ID
	 */

	@RequestMapping(value = "/byid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getRiderById(HttpServletRequest request, @PathVariable("id") String id) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(riderSerivce.findById(Long.parseLong(id))); 
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
	 * Service to get 3 closest driver
	 */

	@RequestMapping(value = "/closest_drivers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getclosestDriver(HttpServletRequest request, @PathVariable("id") String id) {
		ResponseBean responseBean = new ResponseBean();
		try {
			String userToken = request.getHeader("tbs_token");

			if (userToken != null) {

				if (userToken.equalsIgnoreCase(Msg.token)) {

					responseBean.setCode(Msg.SUCCESS_CODE);
					responseBean.setDescription("OK");
					responseBean.setObject(riderSerivce.get_closest_drivers(riderSerivce.findById(Long.parseLong(id))));  
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
