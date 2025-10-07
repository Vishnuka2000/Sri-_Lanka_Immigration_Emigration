package com.example.SriLankaPassport.Dto;

import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Enum.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor           // generates a public no-args constructor
@AllArgsConstructor
public class ApplicantDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private Long NIC;
    private LocalDate DOB;
    private String Applicant_id;
    private Gender gender;
    private String POB;
    private String Nationality;
    private Long ContactNo;
    private String Email;
    private String address01;
    private String address02;

    private Long districtId;
    private String districtName;

    private Long provinceId;
    private String ProvinceName;
    private String postalCode;

    private List<Long> PassportTypeId;
    private List<String> PassportTypeName;

    private Long  applicationTypeId;
    private String applicationType;

    private DeliveryMethod deliveryMethod;

    private Long BranchId;
    private String BranchName;


}


