package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String tagName);

    @Query(value = "select name from tag", nativeQuery = true)
    List<String> findAllTagNames();
}
