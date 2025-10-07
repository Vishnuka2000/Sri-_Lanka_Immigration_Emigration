package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.BranchDto;

import java.util.List;

public interface BranchService {
    BranchDto CreateBranch(BranchDto dto);
    List<BranchDto> getAllBranches();

}
