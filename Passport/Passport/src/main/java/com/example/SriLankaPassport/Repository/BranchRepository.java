package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
