package com.qa.baespring.controller;

import java.util.List;

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

@RequestMapping("/users")
@RestController
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
	public List<User> getAll() {
		return service.getAll();
	}

	// GetByID - get one user
	@GetMapping("/getById/{id}") // localhost:8080/getById/id
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}

	// Post
	@PostMapping("/create") // localhost:8080/create
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	// Put/Patch
	@PutMapping("/update/{id}") // localhost:8080/update
	public User update(@PathVariable long id, @RequestBody User user) {
		return service.update(id, user);
	}

	// Delete
	@DeleteMapping("/delete/{id}") // localhost:8080/delete/id
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}

}
