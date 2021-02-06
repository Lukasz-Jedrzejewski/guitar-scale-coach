package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.model.Guitar;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/practice")
@AllArgsConstructor
public class ScalePracticeController {

    private final GuitarModelService guitarModelService;

    @ModelAttribute("numberOfStrings")
    public List<Integer> numberOfStrings() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return guitarModelService.getEnumValues(NumberOfStrings.class);
    }

    @ModelAttribute("numberOfFrets")
    public List<Integer> numberOfFrets() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return guitarModelService.getEnumValues(NumberOfFrets.class);
    }

    @GetMapping("/guitar-selection")
    public String chooseAGuitarGetAction(Model model) {
        model.addAttribute("guitar", new Guitar());
        return "guitar-selection-form";
    }
}
