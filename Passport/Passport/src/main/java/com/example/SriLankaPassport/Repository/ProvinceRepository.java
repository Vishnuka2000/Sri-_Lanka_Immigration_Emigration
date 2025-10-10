package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Applicant;
import com.example.SriLankaPassport.Entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Optional<Province> findById(long id);
}
