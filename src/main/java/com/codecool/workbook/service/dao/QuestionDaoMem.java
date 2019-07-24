package com.codecool.workbook.service.dao;

import com.codecool.workbook.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionDaoMem {
    private List<Question> questionList = new ArrayList<>();

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questionList.get(random.nextInt(questionList.size()));
    }

    @Override
    public String toString() {
        return "QuestionDaoMem{" +
                "questionList=" + questionList +
                '}';
    }
}
