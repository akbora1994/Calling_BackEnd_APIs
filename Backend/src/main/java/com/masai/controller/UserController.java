package com.masai.controller;

import com.masai.model.User;
import com.masai.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	    @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<String> registerUserHandler(@Valid @RequestBody User user){
	        String message = userService.registerUser(user);
	        return new ResponseEntity<>(message, HttpStatus.OK);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> loginUserHandler(@Valid @RequestBody User user){
	        String message = userService.loginUser(user);
	        return new ResponseEntity<>(message, HttpStatus.OK);
	    }

}
