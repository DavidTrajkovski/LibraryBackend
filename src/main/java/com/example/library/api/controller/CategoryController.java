package com.example.library.api.controller;

import com.example.library.model.enumeration.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CategoryController {

    @GetMapping
    public List<Category> getCategories() {
        return Arrays.stream(Category.values()).sequential().collect(Collectors.toList());
    }

}
