package com.codecool.workbook.controller;

import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.data_handler.TagHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagHandler tagHandler;

    @GetMapping("/all")
    public List<String> getAllTags() {
        return tagHandler.getAllTags();
    }
}
