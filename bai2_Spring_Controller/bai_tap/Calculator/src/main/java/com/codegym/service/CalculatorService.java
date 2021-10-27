package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    public float calculator(float soHang1, float soHang2, String phepTinh) throws Exception;
}
