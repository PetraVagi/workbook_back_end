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
    public Question getRandomQuestionWithAnswer() {

        Question randomQuestion = questionHandler.getOneRandomQuestion();

        while (randomQuestion.getRating() != null && randomQuestion.getRating().isRatedAsKnown()) {
            randomQuestion = questionHandler.getOneRandomQuestion();
        }

        return randomQuestion;
    }

    @GetMapping("/random-question-list")
    public List<Question> getTenRandomQuestions() {
        return questionHandler.getTenRandomQuestions();
    }

    @PostMapping("/add")
    public String addNewQuestionWithAnswer(@RequestBody Question question){
        /**Required JSON example:
         * {
         *     "questionText": "What is data hiding?",
         *     "answers": [
         *        {
         * 			"answerText": "We use encapsulation (or data hiding) to ensure that implementation details are
         * 			not visible to users. To achieve that in Java, declare the class' variables as private and provide
         * 			public setter and getter methods to modify and view the variables' values.",
         * 			"rightAnswer": true
         *        },
         *        {
         *          answerText": "Bad answer",
         *          rightAnswer": false
         *        }
         * 	    ],
         *     "tags": [
         *         "OOP",
         *         "Java"
         *     ],
         *     "room": "OOP"
         * }
         */

        questionHandler.addNewQuestion(question);
        return "New question saved succesfully";
    }


    //TODO Update, delete
    //TODO test: user and unittest

}
