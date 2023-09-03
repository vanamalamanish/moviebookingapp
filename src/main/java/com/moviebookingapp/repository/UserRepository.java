package com.moviebookingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	User findByLoginidAndPassword(String loginid,String password);
	User findByLoginid(String loginid);
	
}
