package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Applicant;
import com.example.SriLankaPassport.Entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    Optional<District> findById(Long id);
}
