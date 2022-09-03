package com.mmacedoaraujo.coursespringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmacedoaraujo.coursespringboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	
	
}
