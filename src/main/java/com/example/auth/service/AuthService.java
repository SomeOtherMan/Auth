package com.example.auth.service;

import com.example.auth.repository.AuthRepository;

public class AuthService {


    public static boolean checkAuth(String username, String password) {
        return AuthRepository.checkAuth(username, password);
    }

}
