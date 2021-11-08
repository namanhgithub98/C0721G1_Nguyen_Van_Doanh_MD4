package com.codegym.model.service.impl;

import com.codegym.model.entity.RegisterForm;
import com.codegym.model.repository.RegisterFormRepository;
import com.codegym.model.service.RegisterFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterFormServiceImpl implements RegisterFormService {

    @Autowired
    private RegisterFormRepository registerFormRepository;
    @Override
    public void save(RegisterForm registerForm) {
        registerFormRepository.save(registerForm);
    }

    @Override
    public List<RegisterForm> findAll() {
        return registerFormRepository.findAll();
    }
}
