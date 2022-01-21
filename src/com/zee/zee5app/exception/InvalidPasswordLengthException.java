package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper=true)
public class InvalidPasswordLengthException extends Exception {
	public InvalidPasswordLengthException(String message) {
		super(message);
	}

}
