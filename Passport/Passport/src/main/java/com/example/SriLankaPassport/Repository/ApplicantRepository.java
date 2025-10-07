package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

}
