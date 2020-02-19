package com.app.outh2server.repository;

import com.app.outh2server.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsernameAndAccountNonExpiredTrue(String userName);

    AppUser findOneByUsernameIgnoreCase(String userId);

    AppUser findOneByEmailIgnoreCase(String email);
}
