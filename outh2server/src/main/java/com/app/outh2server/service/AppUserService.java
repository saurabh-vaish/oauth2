package com.app.outh2server.service;

import com.app.outh2server.dto.AppUserDTO;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public interface AppUserService  {
    AppUserDTO createAppUser(AppUserDTO appUserDTO);
}
