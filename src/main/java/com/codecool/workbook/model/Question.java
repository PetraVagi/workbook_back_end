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
public class Question {

    @Id
    @GeneratedValue
    private Long questionID;

    @Column(length = 500, nullable = false)
    private String questionText;

    @Singular
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<Answer> answers;

    @Singular
    @ManyToMany(mappedBy = "questions", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    private Room room;


    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", questionText='" + questionText + '\'' +
                ", answer='" + answers + '\'' +
                ", tags=" + tags +
                ", room=" + room +
                '}';
    }
}
