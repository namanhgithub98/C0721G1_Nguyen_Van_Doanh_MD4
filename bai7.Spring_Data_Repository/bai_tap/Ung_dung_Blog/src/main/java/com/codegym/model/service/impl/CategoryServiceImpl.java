package com.codegym.model.service.impl;

import com.codegym.model.bean.Category;
import com.codegym.model.repository.CategoryRepository;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(findById(id));
    }
}
