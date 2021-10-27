package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public interface SandwichService {
    public String getCondiments(String[] condiments);
}
