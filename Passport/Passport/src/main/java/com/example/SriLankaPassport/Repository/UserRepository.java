package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
