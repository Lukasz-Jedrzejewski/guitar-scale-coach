package com.jedrzejewski.guitarscalecoach.controller;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;
import com.jedrzejewski.guitarscalecoach.model.Guitar;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

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

    @RequestMapping(value = "/guitar-selection-result", method = {RequestMethod.GET, RequestMethod.POST})
    public String readGuitarAction(@Valid @ModelAttribute Guitar guitar, BindingResult bindingResult,
                                   HttpSession session, Model model, HttpServletRequest request) {
        String referer = null;
        try {
            referer = request.getHeader("Referer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (referer == null) {
            try {
                Guitar currentGuitar = (Guitar) session.getAttribute("currentGuitar");
                List<Sounds> tuning = currentGuitar.getTuning();
                model.addAttribute("tuning", tuning);
                model.addAttribute("frets", guitar.getNumberOfFrets());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (bindingResult.hasErrors()) {
                return "guitar-selection-form";
            } else {
                session.setAttribute("currentGuitar", guitar);
                List<Sounds> tuning = guitar.getTuning();
                System.out.println(tuning);
                model.addAttribute("tuning", tuning);
                model.addAttribute("frets", guitar.getNumberOfFrets());
            }
        }
        return "scale-practice";
    }
}
