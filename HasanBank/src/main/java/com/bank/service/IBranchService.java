package com.bank.service;

import com.bank.entity.BranchEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IBranchService {
    BranchEntity createBranch(BranchEntity branch);
    Optional<BranchEntity> getBranchById(Long id);
    List<BranchEntity> getAllBranchs();
    BranchEntity updateBranch(Long id, BranchEntity updatedBranch);
    void deleteBranch(Long id);
    List<BranchEntity> findBranchsByName(String branchName);
    List<BranchEntity> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
