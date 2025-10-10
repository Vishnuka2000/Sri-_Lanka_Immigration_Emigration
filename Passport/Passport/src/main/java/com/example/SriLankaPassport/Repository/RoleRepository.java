package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
}
