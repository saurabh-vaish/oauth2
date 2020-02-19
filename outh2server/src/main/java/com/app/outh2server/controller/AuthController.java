package com.app.outh2server.controller;

import com.app.outh2server.common.AppResponse;
import com.app.outh2server.common.CustomException;
import com.app.outh2server.common.ErrorMessage;
import com.app.outh2server.common.GlobalValidation;
import com.app.outh2server.dto.AppUserDTO;
import com.app.outh2server.dto.LoginDTO;
import com.app.outh2server.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 20-Feb-20
 */

@RestController
@RequestMapping("/user")
public class AuthController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(loginDTO, HttpStatus.OK);
    }

    @PostMapping("/save/user")
    public AppResponse saveUser(@RequestBody AppUserDTO appUserDTO) {

        try {
            GlobalValidation.isObjectEmpty(appUserDTO, ErrorMessage.INVALID_REQUEST);
            GlobalValidation.isStringEmpty(appUserDTO.getUsername(), ErrorMessage.INVALID_USER_ID);
            GlobalValidation.isStringEmpty(appUserDTO.getEmail(), ErrorMessage.INVALID_USER_EMAIL);

            AppUserDTO dto = appUserService.createAppUser(appUserDTO);
            return new AppResponse(dto, HttpStatus.OK);
        } catch (CustomException ex) {
            return new AppResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

//    @PostMapping("/change")
//    public AppResponse changePassword(@RequestBody ChangePasswordDto dto){
//
//        try{
//            GlobalValidation.isObjectEmpty(dto, ErrorMessage.INVALID_REQUEST);
//            GlobalValidation.isStringEmpty(dto.getUserId(), ErrorMessage.INVALID_USER_ID);
//            GlobalValidation.isStringEmpty(dto.getCurrentPassword(), ErrorMessage.NO_CURRENT_PASSWORD);
//            GlobalValidation.isStringEmpty(dto.getNewPassword(), ErrorMessage.NO_NEW_PASSWORD);
//
//            appUserService.changePassword(dto);
//            return new AppResponse( HttpStatus.OK);
//        }
//        catch (CustomException ex){
//            return new AppResponse(HttpStatus.BAD_REQUEST,ex.getMessage() );
//        }
//    }
//
//
//    @PostMapping("/forget")
//    public AppResponse forgetPassword(@RequestBody LoginDTO dto){
//        try{
//            GlobalValidation.isObjectEmpty(dto, ErrorMessage.INVALID_REQUEST);
//            GlobalValidation.isStringEmpty(dto.getUserId(), ErrorMessage.INVALID_USER_ID);
//
//            ForgetPasswordDto forgetPasswordDto = appUserService.forgetPassword(dto);
//            return new AppResponse(forgetPasswordDto, HttpStatus.OK);
//        }
//        catch (CustomException ex){
//            return new AppResponse(HttpStatus.BAD_REQUEST,ex.getMessage() );
//        }
//    }
}

