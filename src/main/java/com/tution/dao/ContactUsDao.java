package com.tution.dao;

import org.mongodb.morphia.Datastore;

import com.tution.model.ContactUs;
import com.tution.mongo.ConnectionFactory;


public class ContactUsDao {
	
	public static void persist(ContactUs contactUs) {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		datastore.save(contactUs);
	}

}
