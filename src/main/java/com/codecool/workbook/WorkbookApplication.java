package com.codecool.workbook;

import com.codecool.workbook.model.*;
import com.codecool.workbook.service.repository.QuestionRepository;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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

            String[] tagNames = {"Data structures", "Algorithms", "Programming paradigms", "Python", "Debugging",
                    "Version control", "Clean code", "Error handling", "Unix", "Security", "SQL", "HTML",
                    "CSS", "Javascript", "Networks", "Scrum", "OOP", "JAVA", "Database", "Java Enterprise",
                    "Spring", "JPA", "Testing", "DevOps", "Other"};

            if (tagRepository.findAll().isEmpty()) {
                for (String tagName : tagNames) {
                    Tag tag = Tag.builder()
                            .name(tagName)
                            .build();
                    tagRepository.save(tag);
                }
            }

            if (questionRepository.findAll().isEmpty()) {
                Answer trueAnswer1 = Answer.builder()
                    .answerText("Casting means taking an Object of one type and turning it into a different" +
                            "Object type. With downcasting, we are turning the Object into a subtype," +
                            "and with upcasting we are turning it into a supertype. Upcasting is always allowed," +
                            "but downcasting involves a type check that can throw a ClassCastException.")
                    .rightAnswer(true)
                    .build();

                Answer falseAnswer1_1 = Answer.builder()
                        .answerText("Casting")
                        .rightAnswer(false)
                        .build();

                Answer falseAnswer1_2 = Answer.builder()
                        .answerText("Casting")
                        .rightAnswer(false)
                        .build();

                Answer falseAnswer1_3 = Answer.builder()
                        .answerText("Casting")
                        .rightAnswer(false)
                        .build();

                Tag tag1 = tagRepository.findByName("Programming paradigms");

                Question question1 = Question.builder()
                    .questionText("What is casting? What is the difference between up vs downcasting?")
                    .answer(trueAnswer1)
                    .answer(falseAnswer1_1)
                    .answer(falseAnswer1_2)
                    .answer(falseAnswer1_3)
                    .tag(tag1)
                    .room(Room.OOP)
                    .build();

                trueAnswer1.setQuestion(question1);
                falseAnswer1_1.setQuestion(question1);
                falseAnswer1_2.setQuestion(question1);
                falseAnswer1_3.setQuestion(question1);

                tag1.setQuestions(List.of(question1));

                questionRepository.save(question1);


                Answer trueAnswer2 = Answer.builder()
                        .answerText("Constructors are special methods invoked when an object is created and are used to " +
                                "initialize them. A constructor can be used to provide initial values for object attributes.")
                        .rightAnswer(true)
                        .build();

                Answer falseAnswer2_1 = Answer.builder()
                        .answerText("Constructors")
                        .rightAnswer(false)
                        .build();

                Answer falseAnswer2_2 = Answer.builder()
                        .answerText("Constructors")
                        .rightAnswer(false)
                        .build();

                Answer falseAnswer2_3 = Answer.builder()
                        .answerText("Constructors")
                        .rightAnswer(false)
                        .build();

                Tag tag2_1 = tagRepository.findByName("OOP");
                Tag tag2_2 = tagRepository.findByName("JAVA");

                Question question2 = Question.builder()
                        .questionText("What is a constructor?")
                        .answer(trueAnswer2)
                        .answer(falseAnswer2_1)
                        .answer(falseAnswer2_2)
                        .answer(falseAnswer2_3)
                        .tag(tag2_1)
                        .tag(tag2_2)
                        .room(Room.OOP)
                        .build();

                trueAnswer2.setQuestion(question2);
                falseAnswer2_1.setQuestion(question2);
                falseAnswer2_2.setQuestion(question2);
                falseAnswer2_3.setQuestion(question2);

                tag2_1.setQuestions(List.of(question2));
                tag2_2.setQuestions(List.of(question2));

                questionRepository.save(question2);

            }



        };


    }

}
