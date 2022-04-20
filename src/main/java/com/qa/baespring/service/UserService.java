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

	// create a new user
	public User create(User user) {
		return repo.saveAndFlush(user);
	}

	// update a user
	public User update(long id, User user) {
		User existing = repo.findById(id).get(); // get existing user
		existing.setFirstName(user.getFirstName()); // change existing users firstName to new users firstName
		existing.setLastName(user.getLastName()); // change existing users lastName to new users lastName
		existing.setUserName(user.getUserName()); // change existing users username to new users username
		return repo.saveAndFlush(existing); // send new user info back
	}

	// delete an existing user
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id); // want a return true, but if its deleted it will return false
										// so use !
	}

}
