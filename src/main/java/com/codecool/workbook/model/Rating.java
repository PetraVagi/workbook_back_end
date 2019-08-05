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
public class Rating {

    //TODO new rating table for every user

    @Id
    @GeneratedValue
    private Long ratingID;

    @OneToOne
    @JoinColumn(name = "question_id", referencedColumnName = "questionID")
    @EqualsAndHashCode.Exclude
    private Question question;

    private boolean ratedAsKnown;

}
