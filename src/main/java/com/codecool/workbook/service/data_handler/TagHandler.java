package com.codecool.workbook.service.data_handler;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagHandler {

    @Autowired
    private TagRepository tagRepository;

    public List<String> getAllTags() {
        return tagRepository.findAllTagNames();
    }

    public void saveTag(Question question){

        Set<Tag> tags = new HashSet<>();

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
