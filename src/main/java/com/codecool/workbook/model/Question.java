package com.codecool.workbook.model;

import java.util.List;

public class Question {

    private int questionID;
    private String questionText;
    private String answer;
    private List<Tag> tags;
    private Room room;
    private static int ID_COUNTER = 0;

    public Question(String questionText, String answer, List<Tag> tags, Room room) {
        this.questionID = ++ID_COUNTER;
        this.questionText = questionText;
        this.answer = answer;
        //TODO tags, room
//        this.tags = tags;
        this.room = room;
    }

    public int getQuestionID() {
        return questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", questionText='" + questionText + '\'' +
                ", answer='" + answer + '\'' +
                ", tags=" + tags +
                ", room=" + room +
                '}';
    }
}
