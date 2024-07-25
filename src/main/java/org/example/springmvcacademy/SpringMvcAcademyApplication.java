package org.example.springmvcacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
public class SpringMvcAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcAcademyApplication.class, args);
    }


    @Controller
    public class RootController {
       

    }
}