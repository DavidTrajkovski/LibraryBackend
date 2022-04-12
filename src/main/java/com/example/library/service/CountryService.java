package com.example.library.service;

import com.example.library.model.entity.Country;
import com.example.library.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
