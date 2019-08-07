package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
