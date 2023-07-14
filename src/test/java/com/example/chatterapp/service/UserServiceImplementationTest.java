package com.example.chatterapp.service;

import com.example.chatterapp.dto.request.LoginRequest;
import com.example.chatterapp.dto.request.UserRegistrationRequest;
import com.example.chatterapp.dto.response.UserRegistrationResponse;
import com.example.chatterapp.exceptions.InvalidLoginDetails;
import com.example.chatterapp.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplementationTest {
@Autowired
    UserService userService = new UserServiceImplementation();
    UserRegistrationRequest userRegistrationRequest;


    @BeforeEach
    void setUp() {
        userRegistrationRequest = buildUser();
    }
    @AfterEach
    void tearDown(){
        userService.deleteAll();
    }

    @Test
    void testUserRegistration(){
       UserRegistrationResponse savedUser = userService.registerUser(userRegistrationRequest);
       assertNotNull(savedUser);
       assertNotNull(savedUser.getPassWord());
        System.out.println(savedUser.getPassWord());
    }

    @Test
    void testLoginMethod() throws InvalidLoginDetails {
        UserRegistrationResponse savedUser = userService.registerUser(userRegistrationRequest);
        assertNotNull(savedUser);
        LoginRequest request = new LoginRequest();
        request.setEmail("ola@gamil.com");
        request.setPassword("12345");
        userService.login(request);
        Optional<User> foundUser = userService.findById(savedUser.getId());
        assertTrue(foundUser.isPresent());
         assertTrue(foundUser.get().isLoggedIn());

    }



    private UserRegistrationRequest buildUser(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmailAddress("ola@gamil.com");
        request.setRoleTaken("writer");
        request.setFirstName("Ola");
        request.setLastName("ola");
        request.setPassWord("12345");

        return request;

    }


}