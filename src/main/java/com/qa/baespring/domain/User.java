package com.qa.baespring.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// bean - use this class to model a table in a database
@Entity
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"firstName", "lastName", "username" }) })
public class User {

	// Sets this column to auto increment without having to enter the Id ourselves
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// standard data type for id^

	// Properties of the class
	// Creates a column called "first_name" or use @column to override name
	// @Column(name = "firstname")
	// Also use @Column to put a restraint on the column
	@Column(nullable = false)
	private String firstName;

	// creates a column called "last_name"
	@Column(nullable = false)
	private String lastName;

	// Creates a column called "username"
	@Column(unique = true)
	private String username;

	// Default constructor
	public User() {
	}

	// Constructors
	// Used for CRUD- Creating/Inserting
	public User(String firstName, String lastName, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = userName;
	}

	// Used for reading/selecting (and testing)
	public User(long id, String firstName, String lastName, String username) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getUserName()=" + getUserName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	// Generate hashCode() and equals()
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(username, other.username);
	}

}
