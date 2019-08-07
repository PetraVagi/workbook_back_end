package com.codecool.workbook.service.data_handler;

import com.codecool.workbook.model.Answer;
import com.codecool.workbook.service.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerHandler {

    @Autowired
    private AnswerRepository answerRepository;

}
