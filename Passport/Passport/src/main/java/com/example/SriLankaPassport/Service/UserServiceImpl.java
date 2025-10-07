package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.UserDto;
import com.example.SriLankaPassport.Entity.Role;
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
        dto.setId(user.getId());
        dto.setUsername(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastname(user.getLastName());
        dto.setPhoneNumber(user.getPhoneNumber());
        if (user.getRole() != null) {
            dto.setRoleId(user.getRole().getId());
        }
        //dto.setRoleId(user.getRoleId());
        return dto;
    }

    private User mapToEntity(UserDto dto){
        User user=new User();
        user.setId(dto.getId());
        user.setUserName(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastname());
        user.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getRoleId() != null) {
            Role role = new Role();
            role.setId(dto.getRoleId()); // only set ID to reference
            user.setRole(role);
        }
        return user;
    }

    @Override
    public UserDto CreateUser(UserDto userDto){
        User user=mapToEntity(userDto);
        User savedUser=userRepository.save(user);
        return mapToDto(savedUser);
    }

}
