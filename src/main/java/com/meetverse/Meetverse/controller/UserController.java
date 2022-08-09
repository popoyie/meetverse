package com.meetverse.Meetverse.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetverse.Meetverse.model.UserModel;
import com.meetverse.Meetverse.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserRepository repo;
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/signup")
	public boolean createUser(@RequestBody UserModel user) {
		UserModel newuser = new UserModel();
		if (repo.findByEmail(user.getEmail()) == null && repo.findByUsername(user.getUsername()) == null) {
			newuser.setFirstName(user.getFirstName());
			newuser.setLastName(user.getLastName());
			newuser.setEmail(user.getEmail());
			newuser.setUsername(user.getUsername());
			String hashedPassword = passwordEncoder.encode(user.getPassword());
			newuser.setPassword(hashedPassword);
			repo.save(newuser);
			return true;
		}
		return false;

	}

	@PostMapping("/signin")
	public UserModel authUser(@RequestBody UserModel user) {
		UserModel authuser = repo.findByEmail(user.getEmail());
		if (authuser != null) {
			if (passwordEncoder.matches(user.getPassword(), authuser.getPassword())) {
				authuser.setPassword(null);
				return authuser;

			} else {
				return null;
			}
		}
		return null;
	}
	@GetMapping("/user/{id}")
	public Optional<UserModel> getUser(@PathVariable UUID id) {
		Optional<UserModel> user=repo.findById(id);
		user.get().setPassword(null);
		return user;
	}

}
