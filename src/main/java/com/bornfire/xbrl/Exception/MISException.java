package com.bornfire.xbrl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MISException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	 public MISException(String message) {
	        super(message);
	    }

}
