package com.techprimers.security.springsecurityauthserver.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomerUserDetail extends Users implements UserDetails {
    public CustomerUserDetail(final Users users){
        super(users);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("getRoles==>"+getRoles().stream()
                .map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList()));
        //从这里得到用户是 Admin 还是 User
        return getRoles().stream()
                .map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        getAuthorities();
        System.out.println("getPassword"+super.getPassword());
        return super.getPassword();
        //这里其实就是和数据库交互了
    }

    @Override
    public String getUsername() {
        return super.getName();
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
        //证书不会过期
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
