package com.jedrzejewski.guitarscalecoach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instructions")
public class InstructionsController {

    @GetMapping("/general-instructions")
    public String instructionsAction() {
        return "general-instructions";
    }
}
