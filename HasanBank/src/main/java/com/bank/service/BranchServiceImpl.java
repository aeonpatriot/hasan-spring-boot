package com.bank.service;

import com.bank.entity.BranchEntity;
import com.bank.repo.IBranchRepo;
import com.bank.validation.BranchValidation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BranchServiceImpl implements IBranchService {

    @Autowired
    private IBranchRepo branchRepo;

    @Override
    public BranchEntity createBranch(BranchEntity branch) {
        return branchRepo.save(branch);
    }

    @Override
    public Optional<BranchEntity> getBranchById(Long id) {
        return branchRepo.findById(id);
    }

    @Override
    public List<BranchEntity> getAllBranchs() {
        return branchRepo.findAll();
    }

    @Override
    public BranchEntity updateBranch(Long id, BranchEntity updatedBranch) {
        return branchRepo.findById(id).map(existing -> {
            existing.setBranchName(updatedBranch.getBranchName());
            existing.setBranchPostCode(updatedBranch.getBranchPostCode());
            return branchRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
    public void deleteBranch(Long id) {
    	branchRepo.deleteById(id);
    }
    
    @Override
    @Transactional()
    public List<BranchEntity> findBranchsByName(
            String branchName) {
        log.info("Finding branchs by name '{}'", branchName);
        return branchRepo.findByBranchName(branchName);
    }
    
    @Override
    @Transactional()
    public List<BranchEntity> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        log.info("Finding branches by date between {} and {}",startDate, endDate);
        return branchRepo.findByCreationDateBetween(startDate, endDate);
    }
}
