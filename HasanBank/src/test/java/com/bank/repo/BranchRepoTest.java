package com.bank.repo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.BranchEntity;
import com.bank.entity.CustomerEntity;

@SpringBootTest
@ActiveProfiles("test") // Uses application-test.properties for H2 setup

class BranchRepoTest {

    @Autowired
    private IBranchRepo branchRepo;
    
    @AfterEach
    void cleanUp() {
    	branchRepo.deleteAll();  // add this method if not already present
    }

    @Test
    @Order(1)
    void testCreateBranch() {
        BranchEntity branch = new BranchEntity();
        branch.setBranchID(1L);
        branch.setBranchName("KL Branch");
        branch.setBranchPostCode("54000");
        branch.setCreationDate(LocalDateTime.now());

        BranchEntity saved = branchRepo.save(branch);

        assertNotNull(saved.getBranchID());
		assertNotNull("KL Branch", saved.getBranchName());
    }

    @Test
    @Order(2)
    void testFindBranchById() {
    	BranchEntity branch = new BranchEntity();
    	branch.setBranchID(1L);
    	branch.setBranchName("KL Branch");
    	branch.setBranchPostCode("54000");
    	branch.setCreationDate(LocalDateTime.now());

        BranchEntity saved = branchRepo.save(branch);

        Optional<BranchEntity> found = branchRepo.findById(saved.getBranchID());
        
        assertTrue(found.isPresent());
		assertNotNull("KL Branch", found.get().getBranchName());
    }

    @Test
    @Order(3)
    void testDeleteBranch() {
    	BranchEntity branch = new BranchEntity();
    	branch.setBranchID(1L);
    	branch.setBranchName("KL Branch");
    	branch.setBranchPostCode("54000");
    	branch.setCreationDate(LocalDateTime.now());

    	BranchEntity saved = branchRepo.save(branch);
        Long id = saved.getBranchID();

        branchRepo.deleteById(id);

        Optional<BranchEntity> deleted = branchRepo.findById(id);
        assertFalse(deleted.isPresent());
    }
}
