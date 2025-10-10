package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.ApplicantDto;
import com.example.SriLankaPassport.Entity.*;
import com.example.SriLankaPassport.Enum.DeliveryMethod;
import com.example.SriLankaPassport.Repository.ApplicantRepository;
import com.example.SriLankaPassport.Repository.BranchRepository;
import com.example.SriLankaPassport.Repository.DistrictRepository;
import com.example.SriLankaPassport.Repository.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.codec.ServerSentEvent.builder;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private static final Logger log = LoggerFactory.getLogger(ApplicantServiceImpl.class);
    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BranchRepository branchRepository;

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

    public String generateApplicantId() {
        String lastId = Optional.ofNullable(applicantRepository.findTopByOrderByIdDesc())
                .map(Applicant::getApplicantId)
                .orElse("A000");
        int next = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("A%03d", next);
    }



    public ApplicantDto mapToDto(Applicant applicant) {//entity convert to dto
        ApplicantDto dto = new ApplicantDto();
        dto.setId(applicant.getId());
        dto.setFirstName(applicant.getFirstName());
        dto.setLastName(applicant.getLastName());
        dto.setNIC(applicant.getNIC());
        dto.setDOB(applicant.getDOB());
        dto.setGender(applicant.getGender());//entity name using enum
        dto.setPOB(applicant.getPOB());
        dto.setApplicant_id(applicant.getApplicantId());
        dto.setNationality(applicant.getNationality());
        dto.setContactNo(applicant.getContactNo());
        dto.setEmail(applicant.getEmail());
        dto.setAddress01(applicant.getAddress01());
        dto.setAddress02(applicant.getAddress02());
        dto.setDistrictId(applicant.getDistrict().getId());
        dto.setDistrictName(applicant.getDistrict().getDistrictName());
        dto.setId(applicant.getProvince().getId());
       // dto.setProvinceName(applicant.getProvince().getProvinceName());
        dto.setApplicationType(applicant.getApplicationType());
        dto.setPostalCode(applicant.getPostalCode());
        dto.setPassportType(applicant.getPassportType());
        dto.setDeliveryMethod(applicant.getDeliveryMethod());
        dto.setBranchId(applicant.getBranch().getId());
        dto.setBranchName(applicant.getBranch().getBranchName());
        dto.setPassportType(applicant.getPassportType());
        dto.setDeliveryMethod(applicant.getDeliveryMethod());
        dto.setBranchId(applicant.getBranch().getId());
        dto.setBranchName(applicant.getBranch().getBranchName());

//      dto.setPassportTypeId(applicant.getPassportType().getId());
//      dto.setPassportTypeName(applicant.getPassportType().getPassportTypeName());
//        //Convert Set<PassportType> -> List
//        dto.setPassportTypeId(applicant.getPassportType()
//                .stream()
//                .map(PassportType::getId)
//                .collect(Collectors.toList()));
//
//        dto.setPassportTypeName(applicant.getPassportType()
//                .stream()
//                .map(PassportType::getPassportTypeName)
//                .collect(Collectors.toList()));


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
        applicant.setApplicationType(dto.getApplicationType());
        applicant.setPOB(dto.getPOB());
        applicant.setNationality(dto.getNationality());
        applicant.setContactNo(dto.getContactNo());
        applicant.setEmail(dto.getEmail());
        applicant.setAddress01(dto.getAddress01());
        applicant.setAddress02(dto.getAddress02());
        districtRepository.findById(dto.getDistrictId())
                .ifPresent(applicant::setDistrict);
        provinceRepository.findById(dto.getProvince_id())
                .ifPresent(applicant::setProvince);
        branchRepository.findByBranchId(dto.getBranchId())
                .ifPresent(applicant::setBranch);

        applicant.setPostalCode(dto.getPostalCode());
        applicant.setDeliveryMethod(dto.getDeliveryMethod());//applicant.setBranch(dto.getBranch());
        applicant.setPassportType(dto.getPassportType());

//        District district = new District();
//        district.setId(dto.getDistrictId());
//        applicant.setDistrict(district);
//
//        Province province = new Province();
//        province.setId(dto.getProvinceId());
//        applicant.setProvince(province);
//
//        Branch branch = new Branch();
//        branch.setId(dto.getBranchId());
//        applicant.setBranch(branch);

//        ApplicationType applicationType = new ApplicationType();
//        applicationType.setId(dto.getApplicationTypeId());
//        applicant.setApplicationType(applicationType);

//        if (dto.getPassportTypeId() != null && !dto.getPassportTypeId().isEmpty()) {
//            Set<PassportType> passportTypes = dto.getPassportTypeId().stream()
//                    .map(id -> {
//                        PassportType type = new PassportType();
//                        type.setId(id);
//                        return type;
//                    })
//                    .collect(Collectors.toSet());
//            applicant.setPassportType(passportTypes);
//        }
        log.info("Mapping ApplicantDto to Applicant entity: {}", applicant);
        return applicant;
    }

    @Override
    public ApplicantDto CreateApplicant(ApplicantDto applicantDto) {
        Applicant applicant = mapToEntity(applicantDto);
        applicant.setApplicantId(generateApplicantId());
        log.info("Generated Applicant ID: {}", applicant.getApplicantId());
        Applicant saved = applicantRepository.save(applicant);
        return mapToDto(saved);
    }

}
