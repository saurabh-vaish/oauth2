package com.app.outh2server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDTO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private String email;

	private String contactNumber;

	private Set<UserRoleDto> roles = new HashSet<>();


}
