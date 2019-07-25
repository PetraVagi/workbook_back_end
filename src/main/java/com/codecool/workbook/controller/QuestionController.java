package com.codecool.workbook.controller;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.dao.QuestionDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionDaoMem questionDaoMem;

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return questionDaoMem.getRandomQuestion();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public String addDog(@RequestBody Question question){
        this.questionDaoMem.addQuestion(question);
        System.out.println(question.getQuestionID());
        System.out.println(question.getQuestionText());
        return "New question saved successfully";
    }

}
