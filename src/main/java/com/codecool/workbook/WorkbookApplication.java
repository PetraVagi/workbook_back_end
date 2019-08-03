package com.codecool.workbook;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.QuestionRepository;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

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
                    .name("JAVA")
                    .build();

            Answer answer = Answer.builder()
                    .answerText("This is the right answer")
                    .rightAnswer(true)
                    .build();

            Question question2 = Question.builder()
                    .questionText("JAVA QUESTION")
                    .answer(answer)
                    .tag(tag)
                    .build();


            tag.setQuestions(Set.of(question2));

            //TODO make a normal equals method or tag name needs to be unique again (in the db)
            //TODO commit application.properties.skeleton.skeleton
            if (!tagRepository.findAll().contains(tag))
                tagRepository.save(tag);
            questionRepository.save(question2);

        };


    }

}
