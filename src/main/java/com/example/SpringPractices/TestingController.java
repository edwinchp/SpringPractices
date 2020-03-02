package com.example.SpringPractices;

import com.example.SpringPractices.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Slf4j
class ControllerTest {

    @Value("${index.propMessage}")
    private String propMessage;

    @GetMapping("/test")
    public String test(Model model) {
        String message = "This is a message to display in html file";
        model.addAttribute("message", message);
        model.addAttribute("propMessage", propMessage);
        log.info("Something...");
        return "index";
    }

    @GetMapping("/person")
    public String person(Model model){
        Person p = new Person();
        p.setName("Edwin");
        p.setLastName("Chi");
        p.setEmail("chipineiro@gmail.com");
        p.setPhone("9999999999");

        model.addAttribute("persona", p);
        return "index";
    }

}
