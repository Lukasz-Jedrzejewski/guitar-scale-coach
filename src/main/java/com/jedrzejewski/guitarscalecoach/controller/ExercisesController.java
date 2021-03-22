package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.model.ExercisesModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {

    @GetMapping("/general-exercises")
    public String generalExercisesAction(Model model) {
        ExercisesModel exercisesModel = new ExercisesModel();
        model.addAttribute("guitar", exercisesModel);
        return "general-exercises";
    }
}
