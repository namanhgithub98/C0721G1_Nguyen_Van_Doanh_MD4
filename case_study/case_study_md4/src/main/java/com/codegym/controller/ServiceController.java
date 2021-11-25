package com.codegym.controller;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> showServiceTypeList() {
        return serviceService.findAllByServiceType();
    }


    @ModelAttribute("rentTypeList")
    public List<RentType> showRentTypeList() {
        return serviceService.findAllByRentType();
    }

}
