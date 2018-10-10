package com.TaxBooking.taxBooking.Utility;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBean implements Serializable {

	@Autowired
	private static final long serialVersionUID = 1L;
	 @JsonProperty(value="CODE")
     int code;
     @JsonProperty(value="DESCRIPTION")
     String description;
     @JsonProperty(value="OBJECT")
     Object object;
     public int getCode() {
         return code;
     }
     public void setCode(int code) {
         this.code = code;
     }
     public String getDescription() {
         return description;
     }
     public void setDescription(String description) {
         this.description = description;
     }
     public Object getObject() {
         return object;
     }
     public void setObject(Object object) {
         this.object = object;
     }
}
