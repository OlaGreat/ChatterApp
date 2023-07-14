package com.example.chatterapp.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String passWord;
    private String roleTaken;
}
