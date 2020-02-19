package com.app.outh2server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */

@Entity
@Data
@NoArgsConstructor
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(name = "role_name")
        private String roleName;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "permission_role", joinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
                @JoinColumn(name = "permission_id", referencedColumnName = "id")})
        private List<Permission> permissions;


}
