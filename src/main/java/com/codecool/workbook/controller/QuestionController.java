package com.codecool.workbook.controller;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.data_handler.QuestionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionHandler questionHandler;

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return questionHandler.getOneRandomQuestion();
    }

    @GetMapping("/random-question-list")
    public List<Question> getTenRandomQuestions() {
        return questionHandler.getTenRandomQuestions();
    }

    @PostMapping("/add")
    public String addNewQuestion(@RequestBody Question question){
        return questionHandler.addNewQuestion(question);
    }

}
