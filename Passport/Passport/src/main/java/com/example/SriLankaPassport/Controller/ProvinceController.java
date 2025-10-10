package com.example.SriLankaPassport.Controller;

import com.example.SriLankaPassport.Dto.ProvinceDto;
import com.example.SriLankaPassport.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/province")

public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping
    public ProvinceDto CreateProvince(@RequestBody ProvinceDto provincedto){
        return provinceService.CreateProvince(provincedto);
    }



}
