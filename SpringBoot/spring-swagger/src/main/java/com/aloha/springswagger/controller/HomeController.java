package com.aloha.springswagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value = {"/",""})
    public String home() {
        // Swagger 기본경로
        // - /swagger-ui/index.html
        return "redirect:/swagger-ui/index.html";

    }
    
    
}
