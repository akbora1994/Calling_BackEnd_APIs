package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {

	    public String registerUser(User user) throws UserException;
	    public String loginUser(User user) throws UserException;
}
