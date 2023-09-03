package com.moviebookingapp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String loginid;
	@NotNull
	private String password;
	@NotNull
	private String confirmpassword;
	@NotNull
	private String contactno;
	private String role;
}
