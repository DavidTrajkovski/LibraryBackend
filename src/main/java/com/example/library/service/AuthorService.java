package com.example.library.service;

import com.example.library.model.entity.Author;
import com.example.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    final AuthorRepository authorRepository;

    public List<Author> findAuthors() {
        return authorRepository.findAll();
    }
}
