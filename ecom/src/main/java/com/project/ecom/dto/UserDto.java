package com.project.ecom.dto;

import com.project.ecom.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	
	private String email;
	
	private String password;
	
	private UserRole userRole;
}
