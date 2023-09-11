package com.moviebookingapp.controller;

import com.moviebookingapp.model.User;
import com.moviebookingapp.pojo.PasswordRequest;
import com.moviebookingapp.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/moviebooking/")
@ApiModel(description = "This Controller is used to handle Authentication and Authorization for the user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("register")
	@ApiOperation(value = "Register new user to the App",
	notes = "It accepts valid user input such such as unique name, unique email and after all validation is successfully completed, It saves the user data in the table")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		try {
			userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Registration is done successfully...", HttpStatus.CREATED);
	}

	@PostMapping("login")
	@ApiOperation(value = "Login",
	notes = "It allows user to login to the app if the user credentials matches")
	public ResponseEntity<User> validateUser(@RequestParam("loginid") String loginid,
			@RequestParam("password") String password) {
		User user = userService.validateUser(loginid, password);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("{username}/forgot")
	@ApiOperation(value = "Password Reset",
	notes = "It helps the user to reset the password, if they have forgotten the password")
	public ResponseEntity<String> passwordReset(@PathVariable("username") String loginid,
			@RequestBody PasswordRequest passwordRequest) {
		try {
			passwordRequest.setLoginid(loginid);
			userService.passwordReset(passwordRequest);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Password reset is done successfully...", HttpStatus.OK);
	}

}
