package com.example.SriLankaPassport.Dto;

import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Enum.Gender;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long nic;
    private LocalDate DOB;
    private Gender gender;
    private String POB;
    private String Nationality;
    private Long ContactNo;
    private String Email;
    private String address01;
    private String address02;
    private String district;
    private String province;
    private String postalCode;
    private String passportType;
    private String applicationType;
    private DeliveryMethod deliveryMethod;
    private String Branch;
}


