package com.codecool.workbook;

import com.codecool.workbook.model.*;
import com.codecool.workbook.service.repository.QuestionRepository;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

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
    @Profile("production")
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

                Tag tag1 = tagRepository.findByName("Programming paradigms");

                Question question1 = Question.builder()
                    .questionText("What is casting? What is the difference between up vs downcasting?")
                    .answer(trueAnswer1)
                    .tag(tag1)
                    .room(Room.OOP)
                    .build();

                trueAnswer1.setQuestion(question1);

                tag1.setQuestions(List.of(question1));

                questionRepository.save(question1);


                Answer trueAnswer2 = Answer.builder()
                        .answerText("Constructors are special methods invoked when an object is created and are used to " +
                                "initialize them. A constructor can be used to provide initial values for object attributes.")
                        .rightAnswer(true)
                        .build();

                Tag tag2_1 = tagRepository.findByName("OOP");
                Tag tag2_2 = tagRepository.findByName("JAVA");

                Question question2 = Question.builder()
                        .questionText("What is a constructor?")
                        .answer(trueAnswer2)
                        .tag(tag2_1)
                        .tag(tag2_2)
                        .room(Room.OOP)
                        .build();

                trueAnswer2.setQuestion(question2);

                tag2_1.setQuestions(List.of(question2));
                tag2_2.setQuestions(List.of(question2));

                questionRepository.save(question2);




                Answer trueAnswer3 = Answer.builder()
                        .answerText("Method overloading allows us to have more than one method having the same name, " +
                                "if the parameters of methods are different in number, sequence or data types. " +
                                "At compile time, Java knows which method to invoke by checking the method signatures. " +
                                "So this is called compile time polymorphism.")
                        .rightAnswer(true)
                        .build();

                Question question3 = Question.builder()
                        .questionText("What is method overloading?")
                        .answer(trueAnswer3)
                        .tag(tag2_1)
                        .tag(tag2_2)
                        .room(Room.OOP)
                        .build();

                trueAnswer3.setQuestion(question3);

                tag2_1.setQuestions(List.of(question3));
                tag2_2.setQuestions(List.of(question3));

                questionRepository.save(question3);




                Answer trueAnswer4 = Answer.builder()
                        .answerText("An abstract class cannot be instantiated.")
                        .rightAnswer(true)
                        .build();


                Answer falseAnswer4_1 = Answer.builder()
                        .answerText("Exactly one instance can be created for an abstract class.")
                        .rightAnswer(false)
                        .build();


                Answer falseAnswer4_2 = Answer.builder()
                        .answerText("Any number of instances can be created for an abstract class.")
                        .rightAnswer(false)
                        .build();


                Answer falseAnswer4_3 = Answer.builder()
                        .answerText("10 instances can be created for an abstract class.")
                        .rightAnswer(false)
                        .build();

                Question question4 = Question.builder()
                        .questionText("How many instances can be created for an abstract class?")
                        .answer(trueAnswer4)
                        .answer(falseAnswer4_1)
                        .answer(falseAnswer4_2)
                        .answer(falseAnswer4_3)
                        .tag(tag2_1)
                        .tag(tag2_2)
                        .room(Room.OOP)
                        .build();

                trueAnswer4.setQuestion(question4);
                falseAnswer4_1.setQuestion(question4);
                falseAnswer4_2.setQuestion(question4);
                falseAnswer4_3.setQuestion(question4);

                tag2_1.setQuestions(List.of(question4));
                tag2_2.setQuestions(List.of(question4));

                questionRepository.save(question4);


                Answer trueAnswer5 = Answer.builder()
                        .answerText("When no access modifier is specified for a class - " +
                                "It is said to be having the default access modifier by default -" +
                                "it is accessible only within the same package.")
                        .rightAnswer(true)
                        .build();

                Question question5 = Question.builder()
                        .questionText("What is the default access modifier in a class?")
                        .answer(trueAnswer5)
                        .tag(tag2_1)
                        .tag(tag2_2)
                        .room(Room.OOP)
                        .build();

                trueAnswer5.setQuestion(question5);

                tag2_1.setQuestions(List.of(question5));
                tag2_2.setQuestions(List.of(question5));

                questionRepository.save(question5);
            }

        };


    }

}
