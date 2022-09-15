package com.mmacedoaraujo.coursespringboot.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mmacedoaraujo.coursespringboot.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.coursespringboot.domain.User;
import com.mmacedoaraujo.coursespringboot.repository.UserRepository;
import com.mmacedoaraujo.coursespringboot.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(UUID id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepo.save(user);
	}

	public void delete(UUID id) {
		userRepo.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
	}
	
	
}
