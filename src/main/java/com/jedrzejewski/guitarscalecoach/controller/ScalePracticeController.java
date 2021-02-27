package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;
import com.jedrzejewski.guitarscalecoach.model.Guitar;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/practice")
@AllArgsConstructor
public class ScalePracticeController {

    private final GuitarModelService guitarModelService;

    @ModelAttribute("numberOfStrings")
    public List numberOfStrings() {
        return Arrays.asList(NumberOfStrings.values());
    }

    @ModelAttribute("numberOfFrets")
    public List numberOfFrets() {
        return Arrays.asList(NumberOfFrets.values());
    }

    @ModelAttribute("sounds")
    public List sounds() {
        return Arrays.asList(Sounds.values());
    }

    @GetMapping("/guitar-selection")
    public String chooseAGuitarGetAction(Model model) {
        model.addAttribute("guitar", new Guitar());
        return "guitar-selection-form";
    }

    @PostMapping("/guitar-selection")
    public String readGuitarAction(@ModelAttribute Guitar guitar) {
        System.out.println(guitar.getNumberOfStrings().toString());
        System.out.println(guitar.getNumberOfFrets().toString());
        System.out.println(guitar.getTuning().toString());
        System.out.println(guitar.getScale().toString());
        Map<Integer, Sounds> tuning = guitarModelService.createTuning(guitar.getTuning());
        tuning.forEach((key, value) -> System.out.println(key + " " + value));
        return "redirect:/";
    }
}
