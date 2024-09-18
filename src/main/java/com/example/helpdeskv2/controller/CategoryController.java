package com.example.helpdeskv2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.enums.Category;

@RestController
public class CategoryController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category")
    public Category[] getCategories() {
        return Category.values();
    }
}
