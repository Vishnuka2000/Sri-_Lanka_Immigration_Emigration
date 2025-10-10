package com.example.SriLankaPassport.Controller;


import com.example.SriLankaPassport.Dto.ApplicantDto;
import com.example.SriLankaPassport.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/applicants")

public class ApplicantController {
    @Autowired
    private  ApplicantService applicantService;

    @PostMapping
    public ApplicantDto CreateApplicant(@RequestBody ApplicantDto applicantDto){
        return applicantService.CreateApplicant(applicantDto);
    }
}
