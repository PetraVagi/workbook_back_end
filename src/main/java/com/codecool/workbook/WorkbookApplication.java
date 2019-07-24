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
import java.util.Collections;

@SpringBootApplication
public class WorkbookApplication {

    @Autowired
    private QuestionDaoMem questionDaoMem;

    public static void main(String[] args) {
        SpringApplication.run(WorkbookApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        //Until we have DB, Questions will be instantiated here

        questionDaoMem.addQuestion(
                new Question("What is casting? What is the difference between up vs downcasting?",
                        "Casting means taking an Object of one type and turning it into a different " +
                                "Object type. With downcasting, we are turning the Object into a subtype, " +
                                "and with upcasting we are turning it into a supertype. Upcasting is always allowed, " +
                                "but downcasting involves a type check that can throw a ClassCastException.",
                        Collections.singletonList(Tag.PROGRAMMING_PARADIGMS), Room.OOP)
        );
        questionDaoMem.addQuestion(
                new Question("What is a constructor?",
                        "Constructors are special methods invoked when an object is created and are used to " +
                                "initialize them. A constructor can be used to provide initial values " +
                                "for object attributes.",
                        Arrays.asList(Tag.OOP, Tag.JAVA), Room.OOP)
        );
        questionDaoMem.addQuestion(
                new Question("What is method overloading?",
                        "Method overloading allows us to have more than one method having the same name, " +
                                "if the parameters of methods are different in number, sequence or data types. " +
                                "At compile time, Java knows which method to invoke by checking the method signatures. " +
                                "So this is called compile time polymorphism.",
                        Arrays.asList(Tag.OOP, Tag.JAVA), Room.OOP)
        );
        questionDaoMem.addQuestion(
                new Question("How many instances can be created for an abstract class?",
                        "An abstract class cannot be instantiated.",
                        Arrays.asList(Tag.OOP, Tag.JAVA), Room.OOP)
        );
        questionDaoMem.addQuestion(
                new Question("What is the default access modifier in a class?",
                        "When no access modifier is specified for a class - " +
                                "It is said to be having the default access modifier by default - " +
                                "it is accessible only within the same package.",
                        Arrays.asList(Tag.OOP, Tag.JAVA), Room.OOP)
        );

    }

}
