package com.tution.response;

import com.tution.common.GenericResponse;
import com.tution.model.User;

public class UserResponse extends GenericResponse {

	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserResponse( User user) {
		super();
		this.user = user;
	}
	
	public UserResponse( ) {
		super();
	}

}
