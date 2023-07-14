package com.example.chatterapp.service;

import com.example.chatterapp.dto.request.LoginRequest;
import com.example.chatterapp.dto.request.UserRegistrationRequest;
import com.example.chatterapp.dto.response.UserRegistrationResponse;
import com.example.chatterapp.exceptions.InvalidLoginDetails;
import com.example.chatterapp.model.User;
import com.example.chatterapp.model.enums.Role;
import com.example.chatterapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setPassWord(userRegistrationRequest.getPassWord());
        user.setEmail(userRegistrationRequest.getEmailAddress());
        user.setRole(Role.valueOf(userRegistrationRequest.getRoleTaken().toUpperCase()));

        User savedUser =userRepository.save(user);

        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setPassWord(savedUser.getPassWord());
        userRegistrationResponse.setRole(savedUser.getRole());
        userRegistrationResponse.setId(savedUser.getId());

        return userRegistrationResponse;
    }

    @Override
    public void login(LoginRequest loginRequest) throws InvalidLoginDetails {
        String email = loginRequest.getEmail();
        String passWord = loginRequest.getPassword();

        Optional<User> foundUser = userRepository.findByEmail(email);
        if (foundUser.isPresent() && foundUser.get().getPassWord().equals(passWord)){
            foundUser.get().setLoggedIn(true);
        }
        else throw new InvalidLoginDetails("incorrect details please check and renter details again");

    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
