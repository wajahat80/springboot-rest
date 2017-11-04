package net.rwa.springboot.api.response;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordNotFoundException  extends RuntimeException{
	public RecordNotFoundException(String message) {
		super(message);
	}
}
