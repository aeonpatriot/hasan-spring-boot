package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.entity.BranchEntity;
import com.bank.model.BranchDTO;
import com.bank.repo.IBranchRepo;

@SpringBootTest
class BranchMapperTest {

    @Autowired
    private BranchMapper branchMapper;
    
    @Autowired
    private IBranchRepo branchRepo;
    
    @AfterEach
    void cleanUp() {
    	branchRepo.deleteAll();  // add this method if not already present
    }
    
	@Test
    void testEntityToDtoAndBack() {
		BranchEntity entity = new BranchEntity();
		entity.setBranchID(1L);
		entity.setBranchName("Main Branch");
		entity.setBranchPostCode("54000");
		entity.setCreationDate(LocalDateTime.now());
        // Convert to DTO
        BranchDTO dto = branchMapper.toDto(entity);

    	assertNotNull(dto);
    	assertNotNull(dto.getBranchID());
    }
}
