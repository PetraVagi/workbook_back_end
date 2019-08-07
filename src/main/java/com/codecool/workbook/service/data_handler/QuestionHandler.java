package com.codecool.workbook.service.data_handler;


import com.codecool.workbook.model.Question;
import com.codecool.workbook.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionHandler {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagHandler tagHandler;

    public Question getOneRandomQuestion() {
        return questionRepository.getRandomQuestion();
    }

    public List<Question> getTenRandomQuestions() {
        return questionRepository.getTenRandomQuestions();
    }

    public String addNewQuestion(Question question) {

        if (question.getTags() != null) {
            tagHandler.saveTag(question);
        }

        question.getAnswers().forEach(answer -> answer.setQuestion(question));

        this.questionRepository.save(question);

        return "New question saved successfully";
    }

    @Transactional
    public String deleteQuestion(Long questionID){

        if (questionRepository.findByQuestionID(questionID) != null){

            questionRepository.deleteQuestionFromJoinTable(questionID);
            questionRepository.deleteQuestionByQuestionID(questionID);
            return "Question removed from database";

        } else {
            return "Question wasn't in database";
        }
    }
}
