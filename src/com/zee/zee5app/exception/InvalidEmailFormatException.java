package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidEmailFormatException extends Exception {

	public InvalidEmailFormatException(String message) {
		super(message);
	}

}
