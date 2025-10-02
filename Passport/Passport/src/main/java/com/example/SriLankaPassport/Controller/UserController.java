package com.example.SriLankaPassport.Controller;

import com.example.SriLankaPassport.Dto.UserDto;
import com.example.SriLankaPassport.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto CreateUser(@RequestBody UserDto dto){
        return userService.CreateUser(dto);
    }
}
