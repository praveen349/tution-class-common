package com.tution.common;


import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {

	SUCCESS(10000), FAILED(99999), UNSECURE(500), LOGGED_OUT(10011), UNSECURE_LOGGED_IN(9999), RESTRICTED_IP(8888);

	private Integer value;

	private ResponseCode(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer getValue() {
		return value;
	}

}

