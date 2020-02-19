package com.app.outh2server.service.impl;

import com.app.outh2server.entity.AppUser;
import com.app.outh2server.entity.AuthUserDetails;
import com.app.outh2server.repository.AppUserRepository;
import com.app.outh2server.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */

@Service
public class AuthUserServiceImpl implements AuthUserService  {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> user = repository.findByUsernameAndAccountNonExpiredTrue(username);

        user.orElseThrow(()-> new RuntimeException("no user found"));

        AppUser appUser = user.get();

        UserDetails userDetails = new AuthUserDetails(appUser);

        new AccountStatusUserDetailsChecker().check(userDetails); // class to check user details

        return userDetails;

    }
}
