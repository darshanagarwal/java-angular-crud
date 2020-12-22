package com.springboot2.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot2.test.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserNameAndPassword(String userName, String password);

}
