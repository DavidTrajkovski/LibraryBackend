package com.example.library.api.dto;

import com.example.library.model.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    String name;
    Category category;
    Long authorId;
    Integer availableCopies;
}
