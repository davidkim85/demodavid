package com.example.demo.services;


import com.example.demo.entities.AppUser;
import com.example.demo.entities.UserDto;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException(
                        "Problem during authentication!");
        AppUser u = userRepository
                .findUserByUsername(username)
                .orElseThrow(s);
        return new CustomUserDetails(u);
    }
    public AppUser createUser(UserDto userDto) {
        AppUser applicationUser = new AppUser();
        applicationUser.setFirstName(userDto.getFirstName());
        applicationUser.setLastName(userDto.getLastName());
        applicationUser.setEmail(userDto.getEmail());
        applicationUser.setUsername(userDto.getUsername());
        applicationUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(applicationUser);
    }
}
