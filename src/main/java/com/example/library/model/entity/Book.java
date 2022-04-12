package com.example.library.model.entity;

import com.example.library.model.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    //dali two-sided da gi napravis author i countries ss mappedBy?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(value = EnumType.STRING)
    Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    Author author;

    Integer availableCopies;

    public Book(String name, Category c, Author a, int i) {
        this.name = name;
        this.category = c;
        this.author = a;
        this.availableCopies = i;
    }
}
