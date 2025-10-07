package com.example.SriLankaPassport.Controller;

import com.example.SriLankaPassport.Dto.BranchDto;
import com.example.SriLankaPassport.Dto.RoleDto;
import com.example.SriLankaPassport.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping
    public BranchDto CreateBranch(@RequestBody BranchDto branchDto){
        return branchService.CreateBranch(branchDto);
    }

    @GetMapping
    public List<BranchDto> getAllBranches(){
        return branchService.getAllBranches();
    }

}
