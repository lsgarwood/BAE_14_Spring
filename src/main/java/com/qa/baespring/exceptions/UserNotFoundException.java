package com.qa.baespring.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User does not exists with that ID")
public class UserNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4159324449523862724L;

//	public UserNotFoundExceptionWithID(long id) {
// 		super("User does not exist with ID: " + id);
// 	}

}
