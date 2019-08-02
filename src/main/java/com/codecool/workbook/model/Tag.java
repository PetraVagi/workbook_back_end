package com.codecool.workbook.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long tagID;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @Singular
    private Set<Question> questions;

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
