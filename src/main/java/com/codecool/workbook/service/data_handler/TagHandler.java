package com.codecool.workbook.service.data_handler;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagHandler {

    @Autowired
    private TagRepository tagRepository;

    public void saveTag(Question question){
        List<Tag> tags = new ArrayList<>();
        for (Tag tag : question.getTags()) {
            Tag tagInTheDb = tagRepository.findByName(tag.getName());
            if (tagInTheDb == null) {
                tagRepository.saveAndFlush(tag);
                tags.add(tag);
            } else {
                tags.add(tagInTheDb);
            }
            tag.setQuestions(List.of(question));
        }
        question.setTags(tags);
    }
}
