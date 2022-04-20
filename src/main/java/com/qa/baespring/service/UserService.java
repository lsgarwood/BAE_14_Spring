package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	// make connection between the UserRepo and UserService
	private UserRepo repo;

	// create constructor
	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}

	// get by Id (get one user)
	public User getById(long id) {
		return repo.findById(id).get(); // .get() will get user or throw no such element exception
	}

	// get all users
	public List<User> getAll() {
		return repo.findAll();
	}

	// Create a new user
	public User create(User user) {
		return repo.saveAndFlush(user);
	}

}
