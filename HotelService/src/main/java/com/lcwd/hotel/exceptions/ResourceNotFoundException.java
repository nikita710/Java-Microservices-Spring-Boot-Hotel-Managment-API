package com.lcwd.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2765764912626764459L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException() {
		super("Resource not found!");
	}
}
