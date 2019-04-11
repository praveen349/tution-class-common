package com.tution.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;

@Entity(noClassnameStored = true)
@Indexes({ @Index(fields = { @Field(value = "email") }, options = @IndexOptions(name = "email", unique = true)) })
public class User extends GenericModel {
	
	public enum LoginSource {
		EMAIL, SOCIAL
	}

	public enum LoginType {
		EMAIL, FACEBOOK, GOOGLE
	}

	public enum LoginMedium {
		DESKTOP, MOBILE
	}

	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	public enum MaritalStatus {
		MARRIED, UNMARRIED
	}



	private String playerId;
	private String email;
	private String userName;
	private String mobile;
	private String firstName;
	private String lastName;
	private String id;
	private String gameName;
	private UserLogin lastLogin;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getUserName() {
		return userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public UserLogin getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(UserLogin lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	

}

