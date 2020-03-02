package com.example.SpringPractices;

import com.example.SpringPractices.dao.PersonDao;
import com.example.SpringPractices.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class TestingController {

    @GetMapping("/")
    public static String home() {
        return "Hello World!";
    }
}

@Controller
@Slf4j
@PropertySource("classpath:db.credentials.properties")
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
    public String person(Model model) {
        Person p = new Person();
        p.setName("Edwin");
        p.setLastName("Chi");
        p.setEmail("chipineiro@gmail.com");
        p.setPhone("9999999998");

        var p2 = new Person();
        p2.setName("Mildred");
        p2.setLastName("Manrique");
        p2.setEmail("manriquepech@gmail.com");
        p2.setPhone("9999999999");

        var persons = Arrays.asList(p, p2);
        //var persons = new ArrayList();

        log.info("persons= " + persons);
        model.addAttribute("persons", persons);
        return "index";
    }

    @Autowired
    private PersonDao personDao;

    @GetMapping("/database")
    public String database(Model model) {
        var persons = personDao.findAll();
        model.addAttribute("persons", persons);
        return "database";
    }

}
