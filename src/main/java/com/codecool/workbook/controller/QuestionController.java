package com.codecool.workbook.controller;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Room;
import com.codecool.workbook.service.data_handler.QuestionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/all-rooms")
    public List<Room> getAllRooms() {
        return Arrays.asList(Room.values());
    }

    @GetMapping("/id/{question-id}")
    public Question getQuestionById(@PathVariable("question-id") Long questionID){
        return questionHandler.getQuestionById(questionID);
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

        return questionHandler.addNewQuestion(question);
    }

    @PutMapping("/update")
    public String updateQuestion(@RequestBody Question question){
        return "";
    }

    @DeleteMapping("/delete/{question-id}")
    public String deleteQuestionWithAnswers(@PathVariable("question-id") Long questionID){
        return questionHandler.deleteQuestion(questionID);
    }


    //TODO Update
    //TODO test: user and unittest

}
