package com.example.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String surname;

    @ManyToOne
    Country country;

    public Author(String name, String surname, Country c) {
        this.name = name;
        this.surname = surname;
        this.country = c;
    }
}
