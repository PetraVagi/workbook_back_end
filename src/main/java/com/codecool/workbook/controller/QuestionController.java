package com.codecool.workbook.controller;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.dao.QuestionDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionDaoMem questionDaoMem;

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return questionDaoMem.getRandomQuestion();
    }
}
