package com.example.SriLankaPassport.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String Role_id;
    private String phoneNumber;
    private String firstName;
    private String lastname;

}
