package com.codecool.workbook.service.data_handler;


import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuestionHandler {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagHandler tagHandler;

    public Question getRandomQuestion() {
        Random random = new Random();
        return questionRepository.findAll().get(random.nextInt((int) questionRepository.count()));
    }

    public String addNewQuestion(Question question) {
        if (question.getTags() != null) {
            tagHandler.saveTagIfNeeded(question);
        }

        this.questionRepository.save(question);

        return "New question saved successfully";
    }
}
