package com.mmacedoaraujo.coursespringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmacedoaraujo.coursespringboot.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {


    Optional<User> findById(String id);
}
