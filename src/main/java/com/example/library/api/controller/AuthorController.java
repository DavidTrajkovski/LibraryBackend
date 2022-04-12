package com.example.library.api.controller;

import com.example.library.model.entity.Author;
import com.example.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/authors")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class AuthorController {
    final AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.findAuthors();
    }
}
