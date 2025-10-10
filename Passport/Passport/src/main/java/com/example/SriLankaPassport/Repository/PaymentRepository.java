package com.example.SriLankaPassport.Repository;

import com.example.SriLankaPassport.Entity.Applicant;
import com.example.SriLankaPassport.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long > {

}
