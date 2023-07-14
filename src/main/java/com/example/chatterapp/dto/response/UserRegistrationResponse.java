package com.example.chatterapp.dto.response;

import com.example.chatterapp.model.enums.Role;
import lombok.*;
@Data
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {

    private String passWord;
    private Role role;
    private
    String id;

}
