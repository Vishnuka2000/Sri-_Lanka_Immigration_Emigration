package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.PaymentDto;
import com.example.SriLankaPassport.Entity.Payment;
import com.example.SriLankaPassport.Repository.ApplicantRepository;
import com.example.SriLankaPassport.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    private PaymentDto mapToDTO (Payment payment){
        PaymentDto dto=new PaymentDto();
        dto.setId(payment.getId());
        dto.setReceiptNo(payment.getReceiptNo());
        dto.setAmount(payment.getAmount());
        dto.setDateTime(payment.getDateTime());
        dto.setDate(payment.getDate());
        dto.setDescription(payment.getDescription());
        dto.setApplicantId(payment.getApplicant().getApplicantId());
        return dto;
    }


    private Payment mapToEntity(PaymentDto dto){
        Payment payment =new Payment();
        payment.setId(dto.getId());
        payment.setReceiptNo(dto.getReceiptNo());
        payment.setAmount(dto.getAmount());
        payment.setDateTime(dto.getDateTime());
        payment.setDate (dto.getDate());
        payment.setDescription(dto.getDescription());
        applicantRepository.findByApplicantId(dto.getApplicantId())
                .ifPresent(payment::setApplicant);
//        Applicant applicant = applicantRepository.findByApplicantId(dto.getApplicantId())
//                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + dto.getApplicantId()));
//        payment.setApplicant(applicant);//okay

        return payment;

    }

}
