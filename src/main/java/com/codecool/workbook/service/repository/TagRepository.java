package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
