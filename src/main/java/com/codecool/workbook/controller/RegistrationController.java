package com.codecool.workbook.controller;

import com.codecool.workbook.service.data_handler.UserHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    private UserHandler userHandler;

    @PostMapping("/registration")
    public
}
