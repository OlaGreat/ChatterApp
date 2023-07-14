package com.example.chatterapp.model;

import com.example.chatterapp.model.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Document
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private Role role;
    @Id
    private String  id;
    private boolean isLoggedIn;
}
