package com.codegym.dto;


import com.codegym.model.entity.RegisterForm;
import com.codegym.model.service.RegisterFormService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.List;

public class RegisterFormDto implements Validator {
    @Autowired
    private RegisterFormService registerFormService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "not blank")
    @Size(min = 5, max = 45, message = "too short")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^(?=0)\\d{10,11}$",message = "Phone number is not exist")
    private String phoneNumber;

    @NotNull
    @Min(value = 18, message = "Not old enough")
    private int age;

    @NotBlank
    @Email
    private String email;

    public RegisterFormDto() {
    }

    public RegisterFormDto(int id, @NotEmpty @Size(min = 5, max = 45) String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @NotEmpty @Pattern(regexp = "^(?=0)\\d{10,11}$", message = "Phone number is not exist") String phoneNumber, @Min(value = 18, message = "Not old enough") int age, @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterFormDto registerFormDto = (RegisterFormDto) target;
        List<RegisterForm> registerFormList = registerFormService.findAll();

        for (RegisterForm list: registerFormList) {
            if (registerFormDto.getEmail().equals(list.getEmail())) {
                errors.rejectValue("email", "email.duplicate", "Duplicate email. Try another.");
                break;
            }
        }

    }
}
