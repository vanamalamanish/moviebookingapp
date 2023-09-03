package com.moviebookingapp.service;

import com.moviebookingapp.model.User;
import com.moviebookingapp.pojo.PasswordRequest;

public interface UserService {

	public User addUser(User user) throws Exception;
	public User validateUser(String loginid,String password);
	public boolean passwordReset(PasswordRequest passwordRequest) throws Exception;
}
