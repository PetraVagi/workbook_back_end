package com.codecool.workbook.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties("question")
public class Answer {

    @Id
    @GeneratedValue
    private int answerID;

    @Column(length = 1500, nullable = false)
    private String answerText;

    @Column(nullable = false)
    private boolean rightAnswer;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Question question;


}
