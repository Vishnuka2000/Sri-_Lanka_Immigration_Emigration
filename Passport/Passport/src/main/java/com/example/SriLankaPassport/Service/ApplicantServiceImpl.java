package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.ApplicantDto;
import com.example.SriLankaPassport.Entity.*;
import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.codec.ServerSentEvent.builder;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

//    public String generateApplicantId() {
//        // Get last applicant
//        Applicant lastApplicant = applicantRepository.findTopByOrderByIdDesc();
//        if (lastApplicant == null || lastApplicant.getApplicantId() == null) {
//            return "A001";
//        }
//
//        String lastId = lastApplicant.getApplicantId(); // e.g., "A023"
//        int number = Integer.parseInt(lastId.substring(1)); // remove 'A' → 23
//        number++; // next number
//        return String.format("A%03d", number); // "A024"
//    }


    public ApplicantDto mapToDto(Applicant applicant) {//entity convert to dto
        ApplicantDto dto = new ApplicantDto();
        dto.setId(applicant.getId());
        dto.setFirstName(applicant.getFirstName());
        dto.setLastName(applicant.getLastName());
        dto.setNIC(applicant.getNIC());
        dto.setDOB(applicant.getDOB());
        dto.setGender(applicant.getGender());//entity name using enum
        dto.setPOB(applicant.getPOB());
        dto.setNationality(applicant.getNationality());
        dto.setContactNo(applicant.getContactNo());
        dto.setEmail(applicant.getEmail());
        dto.setAddress01(applicant.getAddress01());
        dto.setAddress02(applicant.getAddress02());
        dto.setDistrictId(applicant.getDistrict().getId());
        dto.setDistrictName(applicant.getDistrict().getDistrictName());
        dto.setProvinceId(applicant.getProvince().getId());
        dto.setProvinceName(applicant.getProvince().getProvinceName());
        dto.setApplicationTypeId(applicant.getApplicationType().getId());
        dto.setApplicationType(applicant.getApplicationType().getApplicationTypeName());
        dto.setPostalCode(applicant.getPostalCode());
//        dto.setPassportTypeId(applicant.getPassportType().getId());
//        dto.setPassportTypeName(applicant.getPassportType().getPassportTypeName());
        //Convert Set<PassportType> -> List
        dto.setPassportTypeId(applicant.getPassportType()
                .stream()
                .map(PassportType::getId)
                .collect(Collectors.toList()));

        dto.setPassportTypeName(applicant.getPassportType()
                .stream()
                .map(PassportType::getPassportTypeName)
                .collect(Collectors.toList()));
        dto.setDeliveryMethod(applicant.getDeliveryMethod());
        dto.setBranchId(applicant.getBranch().getId());
        dto.setBranchName(applicant.getBranch().getBranchName());

        return dto;
    }

    public Applicant mapToEntity(ApplicantDto dto){//dto convert to entity
        Applicant applicant =new Applicant();
        applicant.setId(dto.getId());
        applicant.setFirstName(dto.getFirstName());
        applicant.setLastName(dto.getLastName());
        applicant.setNIC(dto.getNIC());
        applicant.setDOB(dto.getDOB());
        applicant.setGender(dto.getGender());
        applicant.setPOB(dto.getPOB());
        applicant.setNationality(dto.getNationality());
        applicant.setContactNo(dto.getContactNo());
        applicant.setEmail(dto.getEmail());
        applicant.setAddress01(dto.getAddress01());
        applicant.setAddress02(dto.getAddress02());

        District district = new District();
        district.setId(dto.getDistrictId());
        applicant.setDistrict(district);

        Province province = new Province();
        province.setId(dto.getProvinceId());
        applicant.setProvince(province);

        Branch branch = new Branch();
        branch.setId(dto.getBranchId());
        applicant.setBranch(branch);

        ApplicationType applicationType = new ApplicationType();
        applicationType.setId(dto.getApplicationTypeId());
        applicant.setApplicationType(applicationType);

        applicant.setPostalCode(dto.getPostalCode());

        applicant.setDeliveryMethod(dto.getDeliveryMethod());//applicant.setBranch(dto.getBranch());

        if (dto.getPassportTypeId() != null && !dto.getPassportTypeId().isEmpty()) {
            Set<PassportType> passportTypes = dto.getPassportTypeId().stream()
                    .map(id -> {
                        PassportType type = new PassportType();
                        type.setId(id);
                        return type;
                    })
                    .collect(Collectors.toSet());
            applicant.setPassportType(passportTypes);
        }

        return applicant;
    }

    @Override
    public ApplicantDto CreateApplicant(ApplicantDto applicantDto) {
        Applicant applicant = mapToEntity(applicantDto);
        Applicant saved = applicantRepository.save(applicant);
        return mapToDto(saved);
    }

}











