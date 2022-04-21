package com.qa.baespring.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User update not successfull")
public class UserUpdateUnsuccessfullException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 891244486279167828L;

}