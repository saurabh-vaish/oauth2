package com.app.outh2server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */

@Entity
@Data
@NoArgsConstructor
public class AuthUserDetails extends AppUser implements UserDetails {

        public AuthUserDetails(AppUser user) {
                super(user);
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {

                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

                getRoles().forEach(role -> {
                        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                        role.getPermissions().forEach(permission -> {
                                grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermission()));
                        });

                });
                return grantedAuthorities;
        }

        @Override
        public String getPassword() {
                return super.getPassword();
        }

        @Override
        public String getUsername() {
                return super.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
                return super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
                return super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
                return super.isEnabled();
        }
}