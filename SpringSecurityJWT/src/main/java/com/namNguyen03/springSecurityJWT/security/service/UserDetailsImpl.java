	package com.namNguyen03.springSecurityJWT.security.service;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.namNguyen03.springSecurityJWT.models.User;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> grantedAuthority;


    public static UserDetails build(User user) {
        return new UserDetailsImpl(user.getUsername(), 
            user.getPassword(), 
            user.
                getRole().
                getName().
                getGrantedAuthorities());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
