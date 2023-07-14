package com.example.chatterapp.service;

import com.example.chatterapp.dto.request.LoginRequest;
import com.example.chatterapp.dto.request.UserRegistrationRequest;
import com.example.chatterapp.dto.response.UserRegistrationResponse;
import com.example.chatterapp.exceptions.InvalidLoginDetails;
import com.example.chatterapp.model.User;

import java.util.Optional;

public interface UserService {
 UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
    void login(LoginRequest loginRequest) throws InvalidLoginDetails;
    Optional<User> findById(String id);

    void deleteAll();
}
