//package com.example.SriLankaPassport.Entity;
//
//import com.example.SriLankaPassport.Enum.Gender;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDate;
//
//@Entity
////@Data
//public class Applicant {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;
//    private String FirstName;
//    private String LastName;
//    private Long NIC;
//    private LocalDate DOB;
//
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    private String POB;//place of birth
//    private String Nationality;
//    private Long ContactNo;
//    private String Email;
//
//    private String address01;
//
//    private String address02;
//
//    @ManyToOne(fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
//    @JoinColumn(name="district_id")
//    private District district;
//
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name="province_id")
//    private Province  province;
//
//    private String postalCode;
//
//    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name="passport_id")
//    private PassportType passportType;
//
//    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name="Application_id")
//    private ApplicationType applicationType;
//
//    @Enumerated(EnumType.STRING)
//    private String deliveryMethod;
//
//    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name="branch_id")
//    private Branch Branch;
//
//
//
//
//
//
//
//}
