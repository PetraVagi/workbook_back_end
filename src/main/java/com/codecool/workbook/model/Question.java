package com.codecool.workbook.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"answers", "tags", "rating"})
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
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @EqualsAndHashCode.Exclude
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    private Room room;

    @OneToOne(mappedBy = "question", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private Rating rating;

}
