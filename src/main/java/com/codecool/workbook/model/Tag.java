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
@JsonIgnoreProperties("questions")
public class Tag {

    @Id
    @GeneratedValue
    private Long tagID;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @EqualsAndHashCode.Exclude
    private List<Question> questions;


    public Tag(String name) {
        this.name = name;
    }

}
