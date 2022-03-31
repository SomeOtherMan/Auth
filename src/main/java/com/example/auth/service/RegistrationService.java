package com.example.auth.service;

import com.example.auth.repository.RegistrationRepository;

public class RegistrationService {

    public static boolean register(String login, String password) {
        return RegistrationRepository.register(login, password);
    }

}
