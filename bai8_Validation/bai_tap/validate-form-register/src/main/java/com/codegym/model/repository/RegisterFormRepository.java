package com.codegym.model.repository;

import com.codegym.model.entity.RegisterForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterFormRepository extends JpaRepository<RegisterForm, Integer> {
}
