package com.example.SpringPractices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("/")
    public static String home(){
        return "Hello World!";
    }

}
