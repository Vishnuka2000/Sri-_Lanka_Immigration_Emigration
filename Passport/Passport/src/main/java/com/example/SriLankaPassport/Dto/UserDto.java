package com.example.SriLankaPassport.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long roleId; // Fixed type and naming
    private String phoneNumber;
    private String firstName;
    private String lastname;

}
