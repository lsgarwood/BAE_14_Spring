package com.qa.baespring.service;

import org.springframework.stereotype.Service;

import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	// make connection between the UserRepo and UserService
	private UserRepo repo;

	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}

}
