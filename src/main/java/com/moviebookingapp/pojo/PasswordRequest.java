package com.moviebookingapp.pojo;

import lombok.Data;

@Data
public class PasswordRequest {

	String loginid;
	String password;
	String confirmpassword;
}
