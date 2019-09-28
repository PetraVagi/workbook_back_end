package com.codecool.workbook.service.data_handler;

import com.codecool.workbook.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    private UserRepository userRepository;
}
