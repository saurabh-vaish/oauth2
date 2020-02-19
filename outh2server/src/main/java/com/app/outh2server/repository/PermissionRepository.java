package com.app.outh2server.repository;

import com.app.outh2server.entity.Permission;
import com.app.outh2server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
