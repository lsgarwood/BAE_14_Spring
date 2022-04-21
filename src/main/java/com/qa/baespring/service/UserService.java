package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.exceptions.UserNotFoundException;
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

	// get all users
	public List<User> getAll() {
		return repo.findAll();
	}

	// get by Id (get one user)
	public User getById(long id) {
		// return repo.findById(id).get(); // .get() will get user if its present or
		// throw no such element exception
		return repo.findById(id).orElseThrow(UserNotFoundException::new); // can also use .orElseThrow(() ->
																			// EntityNotFoundException())
	}

	// get by username (one user)
	public User getByUsername(String username) {
		return repo.findByUsername(username).get();

	}

	// get users by age
	public List<User> getByAge(int age) {
		return repo.findByAge(age);
	}

	// get users by age greater than or equal to
	public List<User> getByAgeGreaterThanEqual(int age) {
		return repo.findByAgeGreaterThanEqual(age);
	}

	// get users by gender
	public List<User> getByGender(String gender) {
		return repo.findByGender(gender);
	}

	// get users by gender specific "male" and age specific ">1=18"
	public List<User> getByGenderAndAge(String gender, int age) {
		return repo.findByGenderAndAge(gender, age);
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
		existing.setAge(user.getAge()); // change existing users age to new age
		return repo.saveAndFlush(existing);// .orElseThrow(UserUpdateUnsuccessfullException::new); // send new user info
											// back
	}

	// delete an existing user
	public boolean delete(long id) {
		repo.deleteById(id); // if we get past this line with no exception it means we know if it exists or
								// not, BUT you cannot assume it has been deleted successfully
		return !repo.existsById(id); // want a return true, but if its deleted it will return false
										// so use ! to double check it has actually deleted
	}

}
