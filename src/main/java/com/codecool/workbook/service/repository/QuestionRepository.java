package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * from question order by random() limit 1", nativeQuery = true)
    Question getRandomQuestion();

    @Query(value = "SELECT * from question order by random() limit 5", nativeQuery = true)
    List<Question> getTenRandomQuestions();
    //TODO limit should be 10 (if there is enough questions)

    Question findByQuestionID(Long questionID);

    void deleteQuestionByQuestionID(Long questionID);

    @Query(value = "delete from question_tag where question_id= :questionID", nativeQuery = true)
    @Modifying
    void deleteQuestionFromJoinTable(@Param("questionID") Long questionID);
}
