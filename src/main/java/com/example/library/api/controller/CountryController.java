package com.example.library.api.controller;

import com.example.library.model.entity.Country;
import com.example.library.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CountryController {
    final CountryService countryService;

    @GetMapping
    public List<Country> getCountries(){
        return countryService.findAll();
    }
}
