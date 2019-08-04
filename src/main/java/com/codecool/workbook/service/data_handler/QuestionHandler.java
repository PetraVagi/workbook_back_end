package com.codecool.workbook.service.data_handler;


import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionHandler {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagHandler tagHandler;

    public Question getRandomQuestion() {

        //TODO Stackoverflow
        Random random = new Random();
        List<Question> questionList = questionRepository.findAll();
        return questionList.get(random.nextInt(questionList.size()));
    }

    public String addNewQuestion(Question question) {

        if (question.getTags() != null) {
            tagHandler.saveTag(question);
        }

        this.questionRepository.save(question);

        return "New question saved successfully";
    }
}
