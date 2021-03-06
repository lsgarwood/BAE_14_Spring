package com.qa.baespring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.baespring.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	// extending the JPARepo comes with a lot built in queries/methods

	Optional<User> findByUsername(String username); // use optional for .get() in custom query

	List<User> findByAgeGreaterThanEqual(int age);

	List<User> findByAge(int age);

	@Query(value = "SELECT * FROM user WHERE gender='male'", nativeQuery = true)
	List<User> findByGender(String gender);

	@Query(value = "SELECT * FROM user WHERE gender='male' AND age>=18", nativeQuery = true)
	List<User> findByGenderAndAge(String gender, int age);

	// Queries using SQL same as above
	// can practice SQL in workbench first then put it into value
	// have to put nativeQuery to true to use SQL or it will use JPQL
//	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
//	Optional<User> findUserByUsername(String username);

	// You can also use JPQL to do the same thing here

}
