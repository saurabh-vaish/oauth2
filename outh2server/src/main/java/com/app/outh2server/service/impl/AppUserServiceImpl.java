package com.app.outh2server.service.impl;

import com.app.outh2server.common.CustomException;
import com.app.outh2server.common.ErrorMessage;
import com.app.outh2server.dto.AppUserDTO;
import com.app.outh2server.entity.AppUser;
import com.app.outh2server.repository.AppUserRepository;
import com.app.outh2server.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public AppUserDTO createAppUser(AppUserDTO appUserDTO) {
        if(appUserRepo.findOneByUsernameIgnoreCase(appUserDTO.getUsername()) != null ){
            throw new CustomException(ErrorMessage.DUPLICATE_USER_ID, HttpStatus.BAD_REQUEST);
        }

        if( appUserRepo.findOneByEmailIgnoreCase(appUserDTO.getEmail())!=null){
            throw new CustomException(ErrorMessage.DUPLICATE_USER_EMAIL, HttpStatus.BAD_REQUEST);
        }

        AppUser appUser = dtoToModel(appUserDTO);

        appUser.setPassword(encoder.encode(appUserDTO.getPassword()));

        appUser = appUserRepo.saveAndFlush(appUser);

        appUser.setPassword(null);

        return modelToDto(appUser);
    }


    private  static AppUser dtoToModel(AppUserDTO appUserDTO){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  mapper.map(appUserDTO, AppUser.class);
    }



    private static AppUserDTO modelToDto(AppUser account){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  mapper.map(account, AppUserDTO.class);
    }






}
