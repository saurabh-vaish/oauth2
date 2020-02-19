package com.app.outh2server.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginReponseDTO {
	
	private String userId;

	private String firstName;

	private String lastName;

//	private UserStatus userStatus;

	private String jwtToken;

	private Set<String> roles = new HashSet<>();

}
