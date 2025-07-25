package com.bank.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.BranchEntity;

@SpringBootTest
@ActiveProfiles("test") // Uses application-test.properties for H2 setup

class BranchSearchTest {

    @Autowired
    private IBranchRepo branchRepo;

    @Test
    void testFindByBranchName() {
        // Arrange
        BranchEntity branch = new BranchEntity();
//        branch.setBranchID(123L);
        branch.setBranchName("Test Branch");
        branch.setBranchPostCode("John");
        branch.setCreationDate(LocalDateTime.now());
        branchRepo.save(branch);

        // Act
        List<BranchEntity> result = branchRepo.findByBranchName("Test Branch");

        // Assert
        assertNotNull(result);
    }

    @Test
    void testFindByCreationDateBetween() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        BranchEntity branch1 = new BranchEntity(null, "Test Branch 1", "54000", now.minusDays(5));
        BranchEntity branch2 = new BranchEntity(null, "Test Branch 2", "53000", now.minusDays(1));
        branchRepo.saveAll(List.of(branch1, branch2));

        // Act
        List<BranchEntity> result = branchRepo.findByCreationDateBetween(
                now.minusDays(10),
                now
        );

        assertNotNull(result);
    }
}
