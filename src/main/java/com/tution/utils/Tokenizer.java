package com.tution.utils;


import java.security.InvalidKeyException;
import java.util.UUID;

import com.google.gson.Gson;

public class Tokenizer {
	// private static Token token;

	public static final String SALT = "780aa58f77b19561cef5b25a03f09f5a#135638b52161fc5e8e6c28f24e34b23f";

	public static String generateUniqueToken() {
		String id = UUID.randomUUID().toString();
		// int keySize = (int) (Math.random() * 128 + 1);
		// int iterationCount = (int) (Math.random() * 128 + 1);

		// will be changed for dynamic key size and iteration
		return id + "-" + 128 + ":" + 1000;
	}

	public static <T> T decrypt(String encryptedData, String key, Class<T> typeParameterClass) throws InvalidKeyException {
		String salt = null, iv = null;
		int ioa = SALT.indexOf("#");
		salt = SALT.substring(0, ioa);
		iv = SALT.substring(ioa + 1);

		Token token = new Token(key);

		AesUtils aesUtil = new AesUtils(token.getKeySize(), token.getIterationCount());
		String plaintext = aesUtil.decrypt(salt, iv, token.getKey(), encryptedData);
		return new Gson().fromJson(plaintext, typeParameterClass);
	}

}

