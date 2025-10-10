package com.example.SriLankaPassport.Dto;

import com.example.SriLankaPassport.Enum.ApplicationType;
import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Enum.Gender;
import com.example.SriLankaPassport.Enum.PassportType;
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
    private String NIC;
    private LocalDate DOB;
    private String Applicant_id;
    private Gender gender;
    private String POB;
    private String Nationality;
    private String ContactNo;
    private String Email;
    private String address01;
    private String address02;

    private Long districtId;
    private String districtName;

    private Long province_id;
    private String ProvinceName;
    private String postalCode;
    private PassportType passportType;

//    private List<Long> PassportTypeId;
//    private List<String> PassportTypeName;

    private ApplicationType applicationType;

//    private Long  applicationTypeId;
//    private String applicationType;

    private DeliveryMethod deliveryMethod;

    private Long BranchId;
    private String BranchName;


}


