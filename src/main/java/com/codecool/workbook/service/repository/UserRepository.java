package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.WorkBookAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<WorkBookAppUser, Long> {
    Optional<WorkBookAppUser> findByUsername(String username);
}
