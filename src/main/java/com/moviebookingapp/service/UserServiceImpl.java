package com.moviebookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.model.User;
import com.moviebookingapp.pojo.PasswordRequest;
import com.moviebookingapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public User addUser(User user) throws Exception{
		if(user.getRole()==null){
			user.setRole("User");
		}
		if (userRepository.findByLoginid(user.getLoginid()) == null) {
			if (validatePassword(user.getPassword(), user.getConfirmpassword())) {
				user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
				return userRepository.save(user);
			} else
				throw new Exception("password and confirm password must be same!!");
		} else
			throw new Exception("Login Id already exists! Please use different id...");
	}

	@Override
	public User validateUser(String loginid, String password) {
		return userRepository.findByLoginidAndPassword(loginid, password);
		
		
	}

	@Override
	public boolean passwordReset(PasswordRequest passwordRequest) throws Exception {
		User user = userRepository.findByLoginid(passwordRequest.getLoginid());
		
		if(user==null) return false;
		
		if(validatePassword(passwordRequest.getPassword(), passwordRequest.getConfirmpassword())) {
		user.setPassword(passwordRequest.getPassword());
		user.setConfirmpassword(passwordRequest.getConfirmpassword());
		userRepository.save(user);
		return true;
		}
		else {
			throw new Exception("password and confirm password must be same!!");
		}
		
	}

	private boolean validatePassword(String password,String confirmpassword) {
		return password.equals(confirmpassword);
		
	}
}
