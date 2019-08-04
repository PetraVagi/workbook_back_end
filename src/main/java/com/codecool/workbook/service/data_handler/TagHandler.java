package com.codecool.workbook.service.data_handler;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagHandler {

    @Autowired
    private TagRepository tagRepository;

    public void saveTagIfNeeded(Question question){
        for (Tag tag : question.getTags()) {
            if (tagRepository.findByName(tag.getName()) == null) {
                tag.setQuestions(List.of(question));
                tagRepository.saveAndFlush(tag);
            }
        }
    }
}
