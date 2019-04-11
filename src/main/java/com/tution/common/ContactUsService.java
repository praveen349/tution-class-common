package com.tution.common;

import org.springframework.stereotype.Component;

import com.tution.dao.ContactUsDao;
import com.tution.model.ContactUs;

@Component
public class ContactUsService {
	
	public GenericBackendResponse contactUsSave(ContactUs contactUs) {
		GenericBackendResponse response = new GenericBackendResponse();
		if (Utils.isNotEmpty(contactUs.getEmail()) && Utils.isNotEmpty(contactUs.getName()) && Utils.isNotEmpty(contactUs.getMessage()) 
				&& Utils.isNotEmpty(contactUs.getMobile())) {
			ContactUsDao.persist(contactUs);
			response.setMsg("your ticket has been raised");
			response.setS(true);
			
			
		} else {
			response.setEd("Fields are missing");
		}
		
		return response;
		
	}
	
		
	
}
