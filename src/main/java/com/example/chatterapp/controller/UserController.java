package com.example.chatterapp.controller;

import com.example.chatterapp.dto.request.UserRegistrationRequest;
import com.example.chatterapp.service.UserService;
import com.example.chatterapp.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/userRequest")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegistrationRequest user){
        var response =  userService.registerUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }


}
