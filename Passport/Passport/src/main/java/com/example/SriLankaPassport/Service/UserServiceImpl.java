package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.UserDto;
import com.example.SriLankaPassport.Entity.User;
import com.example.SriLankaPassport.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;

    private UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(dto.getId());
        dto.setUsername(dto.getUsername());
        dto.setPassword(dto.getPassword());
        dto.setEmail(dto.getEmail());
        dto.setFirstName(dto.getFirstName());
        dto.setLastname(dto.getLastname());
        dto.setPhoneNumber(dto.getPhoneNumber());
        dto.setRole_id(dto.getRole_id());

        return dto;
    }

    private User mapToEntity(UserDto dto){
        User user=new User();
        user.setId(user.getId());
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setRole(user.getRole());
        return user;
    }

    @Override
    public UserDto CreateUser(UserDto userDto){
        User user=mapToEntity(userDto);
        User savedUser=userRepository.save(user);
        return mapToDto(savedUser);
    }

}
