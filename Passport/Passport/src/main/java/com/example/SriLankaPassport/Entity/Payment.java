package com.example.SriLankaPassport.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDateTime;

@Entity
@Table(name="Payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long ReceiptNo;
    private Double Amount;
    private DateFormat Date;
    private LocalDateTime DateTime;

    @ManyToOne(fetch =FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name="applicant_id",nullable = false)
    private  Applicant applicant;

    private String Description;


}
