package com.codecool.workbook.service.repository;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {


    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveOneSimpleQuestion() {
        Question test_question = Question.builder()
                .questionText("Test question")
                .room(Room.ADVANCED)
                .build();

        questionRepository.save(test_question);

        assertThat(questionRepository.findAll()).hasSize(1);
    }

    @Test
    public void answersAreSavedWithQuestion(){
        Answer answer1 = Answer.builder()
                .answerText("Test answer 1")
                .build();

        Answer answer2 = Answer.builder()
                .answerText("Test answer 2")
                .build();

        Question test_question = Question.builder()
                .questionText("Test question")
                .answer(answer1)
                .answer(answer2)
                .room(Room.ADVANCED)
                .build();

        answer1.setQuestion(test_question);
        answer2.setQuestion(test_question);

        questionRepository.save(test_question);

        assertThat(answerRepository.findAll()).hasSize(2);
    }

}