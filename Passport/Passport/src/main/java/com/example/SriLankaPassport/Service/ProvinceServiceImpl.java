package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.ProvinceDto;
import com.example.SriLankaPassport.Entity.Province;
import com.example.SriLankaPassport.Repository.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public ProvinceDto mapToDto(Province province){
        ProvinceDto dto = new ProvinceDto();
        dto.setId(province.getId());
        dto.setProvinceName(province.getProvinceName());
        log.info("Mapping Province entity to ProvinceDto: {}", dto);
        return dto;
    }
    public Province mapToEntity(ProvinceDto dto){
        Province province =new Province();
        province.setId(dto.getId());
        province.setProvinceName(dto.getProvinceName());
        log.info("Mapping ProvinceDto to Province entity: {}", province);
        return province;
    }
    @Override
    public  ProvinceDto CreateProvince(ProvinceDto dto){
        Province province =mapToEntity(dto);
//        log.info("Creating province with details: {}", province);
        Province SavedProvince = provinceRepository.save(province);
        log.info("Province created successfully with ID: {}", SavedProvince);
        return mapToDto(SavedProvince);
    }
}
