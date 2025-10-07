package com.example.SriLankaPassport.Service;

import com.example.SriLankaPassport.Dto.BranchDto;
import com.example.SriLankaPassport.Entity.Branch;
import com.example.SriLankaPassport.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl  implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    private BranchDto mapToDTO(Branch branch){
        BranchDto dto=new BranchDto();
        dto.setId(branch.getId());
        dto.setBranchName(branch.getBranchName());
        dto.setAddress01(branch.getAddress01());
        dto.setCity(branch.getCity());
        dto.setEmail(branch.getEmail());
        return dto;


    }
    private  Branch mapToEntity(BranchDto dto){
        Branch branch=new Branch();
        branch.setId(dto.getId());
        branch.setBranchName(dto.getBranchName());
        branch.setAddress01(dto.getAddress01());
        branch.setCity(dto.getCity());
        branch.setEmail(dto.getEmail());
        return branch;
    }
    @Override
    public BranchDto CreateBranch(BranchDto branchDto){
        Branch branch=mapToEntity(branchDto);
        Branch savedBranch=branchRepository.save(branch);
        return mapToDTO(savedBranch);
    }

    @Override
    public List<BranchDto> getAllBranches(){
        List<Branch> branches=branchRepository.findAll();
        return branches.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
