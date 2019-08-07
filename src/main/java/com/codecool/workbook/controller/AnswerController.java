package com.codecool.workbook.controller;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.service.data_handler.AnswerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerHandler answerHandler;



}
