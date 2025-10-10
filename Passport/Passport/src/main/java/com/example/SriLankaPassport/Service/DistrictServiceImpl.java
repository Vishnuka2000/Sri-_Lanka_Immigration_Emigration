package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.DistrictDto;
import com.example.SriLankaPassport.Entity.District;
import com.example.SriLankaPassport.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl  implements  DistrictService{
    @Autowired
    private DistrictRepository districtRepository;

    public DistrictDto mapToDTO(District district){
        DistrictDto dto =new DistrictDto();
        dto.setId(district.getId());
        dto.setDistrictName(district.getDistrictName());
       return dto;
    }

    public District mapToEntity(DistrictDto dto){
        District district = new District();
        district.setId(dto.getId());
        district.setDistrictName(dto.getDistrictName());
        return district;
    }
   @Override
    public DistrictDto CreateDistrict(DistrictDto districtdto){
        District district =mapToEntity(districtdto);
        District savedDistrict=districtRepository.save(district);
        return mapToDTO(savedDistrict);
    }
}
