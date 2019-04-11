package com.tution.bureau.common.api;



public class ApiMeta {

	private String userToken;
	private String userId;
	private String ip;

	public ApiMeta(String userToken, String userId, String ip) {
		super();
		this.userToken = userToken;
		this.userId = userId;
		this.ip = ip;
	}

	

	public String getUserToken() {
		return userToken;
	}



	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result
				+ ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userToken == null) ? 0 : userToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiMeta other = (ApiMeta) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userToken == null) {
			if (other.userToken != null)
				return false;
		} else if (!userToken.equals(other.userToken))
			return false;
		return true;
	}

}

