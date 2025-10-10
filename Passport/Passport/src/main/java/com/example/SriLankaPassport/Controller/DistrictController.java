package com.example.SriLankaPassport.Controller;

import com.example.SriLankaPassport.Dto.DistrictDto;
import com.example.SriLankaPassport.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/District")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public DistrictDto CreateDistrict(@RequestBody  DistrictDto districtDto){
        return districtService.CreateDistrict(districtDto);
    }





}
