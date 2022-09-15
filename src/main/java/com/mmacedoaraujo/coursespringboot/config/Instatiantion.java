package com.mmacedoaraujo.coursespringboot.config;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mmacedoaraujo.coursespringboot.domain.User;
import com.mmacedoaraujo.coursespringboot.repository.UserRepository;

@Configuration
public class Instatiantion implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User maria = new User(UUID.randomUUID(), "Maria Brown", "maria@gmail.com");
		User alex = new User(UUID.randomUUID(), "Alex Green", "alex@gmail.com");
		User bob = new User(UUID.randomUUID(), "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
