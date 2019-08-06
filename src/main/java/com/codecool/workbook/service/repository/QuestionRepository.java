package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * from question order by random() limit 1;", nativeQuery = true)
    Question getRandomQuestion();

    @Query(value = "SELECT * from question order by random() limit 2;", nativeQuery = true)
    List<Question> getTenRandomQuestions();
    //TODO limit

}
