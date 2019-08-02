package com.codecool.workbook;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Room;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class WorkbookApplication {

    @Autowired
    private QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(WorkbookApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return args -> {
            Tag tag = Tag.builder()
                    .name("Programming paradigms")
                    .build();

            Tag tag2 = Tag.builder()
                    .name("OOP")
                    .build();

            Answer answer = Answer.builder()
                    .answerText("Casting means taking an Object of one type and turning it into a different " +
                            "Object type. With downcasting, we are turning the Object into a subtype, " +
                            "and with upcasting we are turning it into a supertype. Upcasting is always allowed, " +
                            "but downcasting involves a type check that can throw a ClassCastException.")
                    .rightAnswer(true)
                    .build();

            Answer answer2 = Answer.builder()
                    .answerText("XXXXXXXXXX")
                    .rightAnswer(false)
                    .build();

            Question question = Question.builder()
                    .questionText("What is casting? What is the difference between up vs downcasting?")
                    .answer(answer)
                    .answer(answer2)
                    .tag(tag)
                    .tag(tag2)
                    .room(Room.OOP)
                    .build();


            tag.setQuestions(Set.of(question));
            tag2.setQuestions(Set.of(question));

            answer.setQuestion(question);
            answer2.setQuestion(question);

            questionRepository.save(question);

        };


    }

}
