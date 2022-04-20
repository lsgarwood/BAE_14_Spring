package com.qa.baespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	// Get
	// Test with Hello string
//	@GetMapping("/hello") // localhost:8080/hello
//	public String helloWorld() {
//		return "Hello World";
//	}

	// GetAll
	// @GetMapping("/getAll") //localhost:8080/getAll

	// GetByID - get one user
	@GetMapping("/getById/{id}") // localhost:8080/getById/id
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}

	// Post
	// @PostMapping

	// Put/Patch
	// @PutMapping

	// Delete
	// @DeleteMapping

}
