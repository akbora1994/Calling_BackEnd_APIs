package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private UserRepository userRepository;


	    @Override
	    public String registerUser(User user) throws UserException {
	    	
	        if(user.getUsername() == null || user.getPassword() == null) throw new UserException("Please provide a valid username and password for registration.");

	        User registeredUsername = userRepository.findByUsername(user.getUsername());
	        if(registeredUsername != null) throw new UserException("Username already Exist!");

	        User registeredEmail = userRepository.findByEmail(user.getEmail());
	        if(registeredEmail != null) throw new UserException("Email already Exist!");

	        userRepository.save(user);
	        
	        return "User registered successfully!";
	    }

	    @Override
	    public String loginUser(User user) throws UserException {
	    	
	        if(user.getUsername() == null || user.getPassword() == null) throw new UserException("Please provide a valid username and password for registration.");

	        User registeredUser = userRepository.findByUsername(user.getUsername());
	        if(registeredUser == null) throw new UserException("Invalid Userrname!");

	        if(!user.getPassword().equals(registeredUser.getPassword())) throw new UserException("Invalid password!");

	        return "Logined successfully!";
	    }

}
