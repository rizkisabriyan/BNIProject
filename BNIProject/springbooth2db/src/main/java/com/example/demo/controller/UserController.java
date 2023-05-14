package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/user")
	public ResponseEntity<User> save(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser(){
		try {
			List<User> list = userRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		Optional<User> user = userRepo.findById(id);
		
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		try {
			Optional<User> user = userRepo.findById(id);
			if (user.isPresent()) {
				userRepo.delete(user.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
}
