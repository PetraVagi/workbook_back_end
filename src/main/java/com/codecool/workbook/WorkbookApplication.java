package com.codecool.workbook;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Rating;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.QuestionRepository;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WorkbookApplication {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagRepository tagRepository;

    public static void main(String[] args) {
        SpringApplication.run(WorkbookApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return args -> {
//
//            Tag tag = Tag.builder()
//                    .name("OOP")
//                    .build();
//
//
//            Answer answer = Answer.builder()
//                    .answerText("New answer")
//                    .rightAnswer(true)
//                    .build();
//
//
//            Rating rating = Rating.builder()
//                    .rating(30)
//                    .build();
//
//            Question question2 = Question.builder()
//                    .questionText("New question")
//                    .answer(answer)
//                    .tag(tag)
//                    .rating(rating)
//                    .build();
//
//            rating.setQuestion(question2);
//            answer.setQuestion(question2);
//            tag.setQuestions(List.of(question2));
//
//            tagRepository.save(tag);
//            questionRepository.save(question2);

        };


    }

}
