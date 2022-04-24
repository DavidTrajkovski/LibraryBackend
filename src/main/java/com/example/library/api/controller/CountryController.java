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
@AllArgsConstructor
@CrossOrigin(origins = "https://emt-lab2-191027-frontend.herokuapp.com")
@RequestMapping("/api/countries")
public class CountryController {
    final CountryService countryService;

    @GetMapping
    public List<Country> getCountries(){
        return countryService.findAll();
    }
}
