package com.example.library.api.controller;

import com.example.library.api.dto.BookDto;
import com.example.library.model.entity.Book;
import com.example.library.model.exception.BookNotFoundException;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "https://emt-lab2-191027-frontend.herokuapp.com/")
@AllArgsConstructor
public class BookController {
    final BookService bookService;

    //pageable

    @GetMapping(value = {"/all","/"})
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/pagination")
    public List<Book> getAllBooksPagination(Pageable pageable) {
        return bookService.findAllWithPagination(pageable).getContent();
    }
    //ako vrakja Page ovoj metod togas trgni go getContent()

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookService.findBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto) throws Exception {
        return bookService.addBook(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto) throws Exception {
        return bookService.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}/mark")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) throws Exception {
        return bookService.mark(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) throws BookNotFoundException {
        return bookService.delete(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
