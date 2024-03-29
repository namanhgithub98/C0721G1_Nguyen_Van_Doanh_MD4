package com.codegym.controller;

import com.codegym.model.entity.Cart;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showshop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("reduce")) {
            cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("detail")) {
            model.addAttribute("product", productOptional.get());
            cart.addProduct(productOptional.get());
            return "redirect:/detail/{id}";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("/detail", "product", productService.findById(id).get());
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
}