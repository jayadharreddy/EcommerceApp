package com.project.ecom.services.auth;

import com.project.ecom.dto.SignUpRequest;
import com.project.ecom.dto.UserDto;

public interface AuthService {

	UserDto createUser(SignUpRequest signUpRequest);
	
	public boolean hasUserWithEmail(String email); 
}
