package com.example.demo.services;
import com.example.demo.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final AppUser appUser;
    public CustomUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }
    public AppUser getAppUser() {
        return appUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "READ");
    }
    @Override
    public String getPassword() {
        return appUser.getPassword(); }
    @Override
    public String getUsername() {
        return appUser.getUsername(); }
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
