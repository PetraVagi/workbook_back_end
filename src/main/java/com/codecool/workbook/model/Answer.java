package com.codecool.workbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private int answerID;

    @Column(length = 1500, nullable = false)
    private String answerText;

    @Column(nullable = false)
    private boolean rightAnswer;

    @ManyToOne
    private Question question;


}
