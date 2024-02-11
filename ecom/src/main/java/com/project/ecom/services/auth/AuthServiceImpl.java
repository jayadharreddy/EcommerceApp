package com.project.ecom.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ecom.dto.SignUpRequest;
import com.project.ecom.dto.UserDto;
import com.project.ecom.entity.User;
import com.project.ecom.enums.UserRole;
import com.project.ecom.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDto createUser(SignUpRequest signUpRequest) {
		User user= new User();
		
		user.setEmail(signUpRequest.getEmail());
		user.setName(signUpRequest.getName());
		user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
		user.setRole(UserRole.CUSTOMER);
		
		User createdUser =userRepository.save(user);
		
		UserDto userDto= new UserDto();
		userDto.setId(createdUser.getId());
		
		return userDto;
	}
	
	public boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}
	
	@PostConstruct
	public void createAdminAccount() {
		User adminAccount= userRepository.findByRole(UserRole.ADMIN);
		if(null== adminAccount) {
			User user= new User();
			user.setEmail("admin@test.com");
			user.setName("admin");
			user.setRole(UserRole.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
