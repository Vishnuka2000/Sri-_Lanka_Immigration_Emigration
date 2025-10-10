package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    // Custom method to find by the string applicant_id (not the primary key)
    Applicant findTopByOrderByIdDesc();
    Optional<Applicant> findByApplicantId(String  applicantId);
}
