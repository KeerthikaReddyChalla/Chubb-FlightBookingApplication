package com.flightapp.service.impl;

import com.flightapp.config.JwtUtil;
import com.flightapp.dto.*;
import com.flightapp.model.Role;
import com.flightapp.model.User;
import com.flightapp.repository.RoleRepository;
import com.flightapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public String register(RegisterRequest req) {

    	if (userRepo.findByEmail(req.getEmail()).isPresent()) {
    	    throw new DuplicateKeyException("User already exists with email: " + req.getEmail());
    	}

        Role role = roleRepo.findByName("ROLE_USER")
                .orElseGet(() -> roleRepo.save(Role.builder().name("ROLE_USER").build()));

        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(Set.of(role))
                .build();

        userRepo.save(user);

        return jwtUtil.generateToken(req.getEmail());
    }

    public String login(LoginRequest req) {

        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + req.getEmail()));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        return jwtUtil.generateToken(req.getEmail());
    }
}
