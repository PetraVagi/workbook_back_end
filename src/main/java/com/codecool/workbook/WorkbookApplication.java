package com.codecool.workbook;

import com.codecool.workbook.model.Question;
import com.codecool.workbook.model.Room;
import com.codecool.workbook.model.Tag;
import com.codecool.workbook.service.dao.QuestionDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class WorkbookApplication {

    @Autowired
    private QuestionDaoMem questionDaoMem;

    public static void main(String[] args) {
        SpringApplication.run(WorkbookApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println(questionDaoMem);
    }

}
