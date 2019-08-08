package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating findByQuestionQuestionID(Long questionID);

    @Query(value = "UPDATE rating SET rated_as_known = true WHERE question_id= :questionID", nativeQuery = true)
    @Modifying
    void updateRatingToTrue(@Param("questionID") Long questionId);

    @Query(value = "delete from rating where question_id= :questionID", nativeQuery = true)
    @Modifying
    void deleteQuestionFromRatingTable(@Param("questionID") Long questionID);
}
