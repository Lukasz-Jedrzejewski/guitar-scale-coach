package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.model.Guitar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/practice")
public class ScalePracticeController {

    @ModelAttribute("numberOfStrings")
    public List<NumberOfStrings> numberOfStrings() {
        return Arrays.asList(NumberOfStrings.values());
    }

    @ModelAttribute("numberOfFrets")
    public List<NumberOfFrets> numberOfFrets() {
        return Arrays.asList(NumberOfFrets.values());
    }

    @GetMapping("/guitar-selection")
    public String chooseAGuitarGetAction(Model model) {
        model.addAttribute("guitar", new Guitar());
        return "guitar-selection-form";
    }
}
