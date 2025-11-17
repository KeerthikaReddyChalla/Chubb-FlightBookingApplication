package com.flightapp.service;

import com.flightapp.dto.LoginRequest;
import com.flightapp.dto.RegisterRequest;
import com.flightapp.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);
}
