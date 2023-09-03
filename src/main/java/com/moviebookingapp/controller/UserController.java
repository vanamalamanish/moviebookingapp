package com.moviebookingapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingapp.model.User;
import com.moviebookingapp.service.UserService;

@RestController
@RequestMapping("/api/v1.0/moviebooking/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		try {
		userService.addUser(user);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Registration is done successfully...",HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<User> validateUser(@RequestParam("loginid") String loginid,@RequestParam("password") String password){
		User user  = userService.validateUser(loginid, password);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
	

}
