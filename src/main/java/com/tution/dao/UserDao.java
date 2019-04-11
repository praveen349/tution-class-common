package com.tution.dao;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.tution.model.ContactUs;
import com.tution.model.User;
import com.tution.mongo.ConnectionFactory;


public class UserDao {
	
	public static void persist(ContactUs contactUs) {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		datastore.save(contactUs);
	}
	
	public static User userLogIn(String email, String password) throws NoSuchAlgorithmException, IOException {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		Query<User> query = datastore.createQuery(User.class).field("email").equal(email.toLowerCase()).field("password").equal(password);
		return query.get(); 
	} 
	
	public static User getUser(String email) throws NoSuchAlgorithmException, IOException {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		Query<User> query = datastore.createQuery(User.class).field("email").equal(email.toLowerCase());
		return query.get(); 
	} 
	
	public static User getById(String id) throws NoSuchAlgorithmException, IOException {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		Query<User> query = datastore.createQuery(User.class).field("id").equal(id);
		return query.get(); 
	} 
	
	public static void updateLastLogin(String id, String token) {
		Datastore datastore = ConnectionFactory.getInstance().getDatastore();
		Query<User> query = datastore.createQuery(User.class);
		query.field("id").equal(id);
		UpdateOperations<User> ops = datastore.createUpdateOperations(User.class);
		ops.set("token", token);
		ops.set("lastLogin.time", new Date());
		ops.set("lastLogin.loggedIn", true);
		datastore.update(query, ops, false);
	}

}
