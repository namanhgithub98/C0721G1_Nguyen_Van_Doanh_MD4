package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String showForm() {
        return "/index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("txtSearch") String txtSreach, Model model) {
        String result = dictionaryService.translate(txtSreach);
        model.addAttribute("txtSreach" , txtSreach);
        model.addAttribute("result", result);
        return "/result";

    }
}
