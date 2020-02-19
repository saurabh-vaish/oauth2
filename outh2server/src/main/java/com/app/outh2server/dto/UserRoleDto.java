package com.app.outh2server.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UserRoleDto {

	private Long id;

	private String role;

	private List<UserPermissionDto> permissions;

}
