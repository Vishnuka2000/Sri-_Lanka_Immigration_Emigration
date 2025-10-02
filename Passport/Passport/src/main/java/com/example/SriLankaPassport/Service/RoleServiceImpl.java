package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.RoleDto;
import com.example.SriLankaPassport.Entity.Role;
import com.example.SriLankaPassport.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private RoleDto mapToDTO(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }

    private Role mapToEntity(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setRoleName(dto.getRoleName());
        return role;
    }

   @Override
    public RoleDto CreateRole (RoleDto roledto){
      Role role=mapToEntity(roledto);
      Role savedRole=roleRepository.save(role);
      return mapToDTO(savedRole);
    }


}