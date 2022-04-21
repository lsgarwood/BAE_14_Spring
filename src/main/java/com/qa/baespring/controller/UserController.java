package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
@CrossOrigin // where it originates from- requests can come from anywhere on computer
@RequestMapping("/users")
public class UserController { // All request handling

	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	// Get
	// Test with Hello string
	@GetMapping("/hello") // localhost:8080/hello
	public String helloWorld() {
		return "Hello World";
	}

	// GetAll
	@GetMapping("/getAll") // localhost:8080/getAll
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}

	// GetByID - get one user
	@GetMapping("/getById/{id}") // localhost:8080/getById/id
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}

	// getByUsername - get one user by username
	@GetMapping("/getByUsername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		return new ResponseEntity<User>(service.getByUsername(username), HttpStatus.OK);
	}

	// getByAge - get users by age
	@GetMapping("/getByAge/{age}")
	public ResponseEntity<List<User>> getByAge(@PathVariable int age) {
		return new ResponseEntity<List<User>>(service.getByAge(age), HttpStatus.OK);
	}

	// getByAgeGreaterThanEqual to
	@GetMapping("/getByAgeGreaterThanEqual/{age}")
	public ResponseEntity<List<User>> getByAgeGreaterThanEqual(@PathVariable int age) {
		return new ResponseEntity<List<User>>(service.getByAgeGreaterThanEqual(age), HttpStatus.OK);
	}

	// getByGender
	@GetMapping("/getByGender/{gender}")
	public ResponseEntity<List<User>> getByGender(@PathVariable String gender) {
		return new ResponseEntity<List<User>>(service.getByGender(gender), HttpStatus.OK);
	}

	// Post
	@PostMapping("/create") // localhost:8080/create
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}

	// Put/Patch
	@PutMapping("/update/{id}") // localhost:8080/update
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.CREATED);
	}

	// Delete
	@DeleteMapping("/delete/{id}") // localhost:8080/delete/id
	public ResponseEntity<?> delete(@PathVariable long id) { // ? is wildcard, could be any type of data as its not
																// used, it will always be no content
		return (service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : // dont need to reference wilcard
																					// again after the first^
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// @DeleteMapping("/delete/{id}") not using ternary if
	// public ResponseEntity<?> delete(@PathVariable long id) {
	// if (service.delete(id) == true) {
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// } else {
	// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// }

}
