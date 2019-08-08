package com.codecool.workbook.service.data_handler;


import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Rating;
import com.codecool.workbook.service.repository.QuestionRepository;
import com.codecool.workbook.service.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionHandler {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private TagHandler tagHandler;

    public Question getOneRandomQuestion() {
        Question randomQuestion = questionRepository.getRandomQuestion();

        while (randomQuestion.getRating() != null && randomQuestion.getRating().isRatedAsKnown()) {
            randomQuestion = questionRepository.getRandomQuestion();
        }

        return randomQuestion;
    }

    public List<Question> getTenRandomQuestions() {
        return questionRepository.getTenRandomQuestions();
    }

    public Question getQuestionById(Long questionID) {
        return questionRepository.findByQuestionID(questionID);
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

            ratingRepository.deleteQuestionFromRatingTable(questionID);
            questionRepository.deleteQuestionFromJoinTable(questionID);
            questionRepository.deleteQuestionByQuestionID(questionID);
            return "Question removed from database";

        } else {
            return "Question wasn't in database";
        }
    }

    public String markQuestionAsKnown(Long questionID) {

        if(ratingRepository.findByQuestionQuestionID(questionID) != null){
            if (!ratingRepository.findByQuestionQuestionID(questionID).isRatedAsKnown()) {
                ratingRepository.updateRatingToTrue(questionID);
                return "Question updated as known";
            } else {
                return "Question was already marked as known";
            }

        } else {
            Rating rating = Rating.builder()
                    .ratedAsKnown(true)
                    .question(questionRepository.findByQuestionID(questionID))
                    .build();
            ratingRepository.save(rating);
            return "Question marked as known";
        }
    }
}
