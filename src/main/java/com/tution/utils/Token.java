package com.tution.utils;


import java.security.InvalidKeyException;

public class Token {

	private String key;

	private int keySize;

	private int iterationCount;

	public Token() {
	}

	public Token(String token) throws InvalidKeyException {
		int lastIndexOfHyphen = token.lastIndexOf("-");
		if (lastIndexOfHyphen > 10) {
			String ksitc = token.substring(lastIndexOfHyphen + 1);
			if (ksitc.length() > 2) {
				int ioc = ksitc.indexOf(":");
				this.keySize = Integer.parseInt(ksitc.substring(0, ioc));
				this.iterationCount = Integer.parseInt(ksitc.substring(ioc + 1));
				if (this.keySize > 0 && this.iterationCount > 0) {
					this.key = token.substring(0, lastIndexOfHyphen);
				} else
					invalidKeyException();
			} else
				invalidKeyException();
		} else
			invalidKeyException();
	}

	private void invalidKeyException() throws InvalidKeyException {
		throw new InvalidKeyException("Key is not generated throw Tokenizer class");
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getKeySize() {
		return keySize;
	}

	public void setKeySize(int keySize) {
		this.keySize = keySize;
	}

	public int getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(int iterationCount) {
		this.iterationCount = iterationCount;
	}

}

