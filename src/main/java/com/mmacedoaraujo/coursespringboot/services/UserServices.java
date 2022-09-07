package com.mmacedoaraujo.coursespringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.coursespringboot.domain.User;
import com.mmacedoaraujo.coursespringboot.repository.UserRepository;
import com.mmacedoaraujo.coursespringboot.services.exceptions.ObjectNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user =  userRepo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user.get();
	}

	public User insert(User user) {
		return userRepo.save(user);
	}
	
	
}
