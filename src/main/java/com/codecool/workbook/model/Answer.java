package com.codecool.workbook.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "answerID")
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
