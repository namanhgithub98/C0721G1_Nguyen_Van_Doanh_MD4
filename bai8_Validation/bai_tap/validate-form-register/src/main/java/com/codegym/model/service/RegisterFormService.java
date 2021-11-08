package com.codegym.model.service;

import com.codegym.model.entity.RegisterForm;

import java.util.List;

public interface RegisterFormService {
     void save(RegisterForm registerForm);

     List<RegisterForm> findAll();

    }
