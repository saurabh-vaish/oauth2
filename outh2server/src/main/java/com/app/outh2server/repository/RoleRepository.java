package com.app.outh2server.repository;

import com.app.outh2server.entity.AppUser;
import com.app.outh2server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
