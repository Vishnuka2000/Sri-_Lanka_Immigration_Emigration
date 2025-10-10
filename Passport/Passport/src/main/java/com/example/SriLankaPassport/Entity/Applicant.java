package com.example.SriLankaPassport.Entity;

import com.example.SriLankaPassport.Enum.ApplicationType;
import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Enum.Gender;
import com.example.SriLankaPassport.Enum.PassportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor           // generates a public no-args constructor
@AllArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String FirstName;
    private String LastName;
    private String NIC;
    private LocalDate DOB;
    @Column(unique = true)
    private String  applicantId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String POB;//place of birth
    private String Nationality;
    private String ContactNo;
    private String Email;

    private String address01;

    private String address02;

    @ManyToOne(fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name="district_id")
    private District district;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="province_id")
    private Province  province;

    private String postalCode;

//   @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//   @JoinColumn(name="passport_id")
//   private PassportType passportType;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "applicant_passport_type",
//            joinColumns = @JoinColumn(name = " Applicant_id"),
//            inverseJoinColumns = @JoinColumn(name = "passport_id")
//    )
//    private Set<PassportType> passportType = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private PassportType passportType;

    @Enumerated(EnumType.STRING)
    private ApplicationType applicationType;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="branch_id")
    private Branch Branch;

}
