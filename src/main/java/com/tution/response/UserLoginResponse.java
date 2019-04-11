package com.tution.response;

import com.tution.common.GenericResponse;
import com.tution.model.User;

public class UserLoginResponse extends GenericResponse {

	private String transactionId;

	private boolean termAccepted;

	private User user;
	
	private String token;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	

	public boolean isTermAccepted() {
		return termAccepted;
	}

	public void setTermAccepted(boolean termAccepted) {
		this.termAccepted = termAccepted;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

}

