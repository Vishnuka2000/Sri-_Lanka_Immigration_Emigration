package com.example.SriLankaPassport.Dto;

import com.example.SriLankaPassport.Entity.Applicant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Long ReceiptNo;
    private Double Amount;
    private DateFormat Date;
    private LocalDateTime DateTime;
    private String applicantId;
    private String Description;

}
