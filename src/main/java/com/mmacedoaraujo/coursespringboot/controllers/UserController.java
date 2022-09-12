package com.mmacedoaraujo.coursespringboot.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mmacedoaraujo.coursespringboot.domain.User;
import com.mmacedoaraujo.coursespringboot.dto.UserDTO;
import com.mmacedoaraujo.coursespringboot.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userServices;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userServices.findAll();
		List<UserDTO> dtoList = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(dtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userServices.findById(id);

		return ResponseEntity.ok().body(new UserDTO(user));
	}
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = userServices.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(user);
	}

}
