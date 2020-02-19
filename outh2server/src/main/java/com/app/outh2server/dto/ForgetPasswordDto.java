package com.app.outh2server.dto;

import lombok.Data;

/***
 * @author saurabh vaish
 * @version 1.0
 * @since 19/02/20
 ***/

@Data
public class ForgetPasswordDto {

    private String userId;

    private String newPassword;

    private Boolean forceChangePassword = Boolean.TRUE;

    public ForgetPasswordDto(String userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }
}
