package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.model.ExercisesModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instructions")
public class InstructionsController {

    @GetMapping("/general-instructions")
    public String instructionsAction(Model model) {
        ExercisesModel exercisesModel = new ExercisesModel();
        model.addAttribute("guitar", exercisesModel);
        return "general-instructions";
    }
}
