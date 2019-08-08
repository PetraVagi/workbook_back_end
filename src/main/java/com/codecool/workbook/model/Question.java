package com.codecool.workbook.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "questionID")
public class Question {

    @Id
    @GeneratedValue
    private Long questionID;

    @Column(length = 500, nullable = false)
    private String questionText;

    @Singular
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @EqualsAndHashCode.Exclude
    private Set<Answer> answers;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @EqualsAndHashCode.Exclude
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    private Room room;

    @OneToOne(mappedBy = "question")
    private Rating rating;

}
