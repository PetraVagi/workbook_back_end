package com.codecool.workbook;

import com.codecool.workbook.model.*;
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

            Tag tag = Tag.builder()
                    .name("Programming paradigms")
                    .build();


            Answer answer = Answer.builder()
                    .answerText("Casting means taking an Object of one type and turning it into a different" +
                            "Object type. With downcasting, we are turning the Object into a subtype," +
                            "and with upcasting we are turning it into a supertype. Upcasting is always allowed," +
                            "but downcasting involves a type check that can throw a ClassCastException.")
                    .rightAnswer(true)
                    .build();


            Rating rating = Rating.builder()
                    .ratedAsKnown(false)
                    .build();

            Question question = Question.builder()
                    .questionText("What is casting? What is the difference between up vs downcasting?")
                    .answer(answer)
                    .tag(tag)
                    .rating(rating)
                    .room(Room.OOP)
                    .build();

            tag.setQuestions(List.of(question));
            answer.setQuestion(question);
            rating.setQuestion(question);

            tagRepository.save(tag);
            questionRepository.save(question);

        };


    }

}
