package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.model.Guitar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice")
public class ScalePracticeController {

    @GetMapping("/guitar-selection")
    public String chooseAGuitarGetAction(Model model) {
        model.addAttribute("guitar", new Guitar());
        return "guitar-selection-form";
    }
}
