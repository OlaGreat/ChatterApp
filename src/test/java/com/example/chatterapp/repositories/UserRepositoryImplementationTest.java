package com.example.chatterapp.repositories;
import com.example.chatterapp.model.User;
import com.example.chatterapp.model.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryImplementationTest {
    @Autowired
    UserRepository userRepository;
    private User savedUser;


    @BeforeEach
    void setUp() {
        User user = buildUser();
        savedUser = userRepository.save(user);
    }

    @Test
    void testMethodSave(){
        assertNotNull(savedUser);
    }
    @Test
    void testUserCanBeFindByUserName(){
        assertNotNull(savedUser);
//        Optional foundUser =
    }



    private User buildUser(){
        User user = new User();
        user.setEmail("ola@gamil.com");
        user.setRole(Role.valueOf("writer".toUpperCase()));
        user.setFirstName("Ola");
        user.setLastName("ola");
        user.setPassWord("12345");

        return user;

    }
}