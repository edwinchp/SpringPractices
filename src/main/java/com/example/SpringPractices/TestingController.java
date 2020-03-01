package com.example.SpringPractices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("/")
    public static String home() {
        return "Hello World!";
    }
}

@Controller
class ControllerTest {

    @GetMapping("/test")
    public static String test() {
        return "index";
    }

}
