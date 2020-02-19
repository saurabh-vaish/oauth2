package com.app.outh2server.dto;

import lombok.Data;

/***
 * @author saurabh vaish
 * @version 1.0
 * @since 19/02/20
 ***/

@Data
public class ChangePasswordDto {

    private String userId;

    private String currentPassword;

    private String newPassword;

}
