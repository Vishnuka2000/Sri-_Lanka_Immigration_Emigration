package com.example.SriLankaPassport.Controller;

import com.example.SriLankaPassport.Dto.RoleDto;
import com.example.SriLankaPassport.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public RoleDto CreateRole(@RequestBody RoleDto roleDto){
        return roleService.CreateRole(roleDto);
    }

}
