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
public class Rating {

    //TODO new rating table for every user

    @Id
    @GeneratedValue
    private Long ratingID;

    @OneToOne
    @JoinColumn(name = "question_id", referencedColumnName = "questionID")
    private Question question;

    private boolean ratedAsKnown;

}
