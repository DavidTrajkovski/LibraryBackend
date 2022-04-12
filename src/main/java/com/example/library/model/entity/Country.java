package com.example.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="countries")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
