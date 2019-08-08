package com.codecool.workbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "question_id", referencedColumnName = "questionID")
    @JsonIgnore
    private Question question;

    private boolean ratedAsKnown;

}
