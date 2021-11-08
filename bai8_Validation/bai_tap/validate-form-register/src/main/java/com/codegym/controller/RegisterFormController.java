package com.codegym.controller;

import com.codegym.dto.RegisterFormDto;
import com.codegym.model.entity.RegisterForm;
import com.codegym.model.service.RegisterFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterFormController {
    @Autowired
    private RegisterFormService registerFormService;


    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("create", "registerFormDto", new RegisterFormDto());
    }


    @PostMapping("/create")
    public String checkValidation(@Valid @ModelAttribute RegisterFormDto registerFormDto, BindingResult bindingResult, Model model) {
        new RegisterFormDto().validate(registerFormDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            RegisterForm registerForm = new RegisterForm();
            BeanUtils.copyProperties(registerFormDto, registerForm);
            registerFormService.save(registerForm);
            return "result";
        }
    }
}
