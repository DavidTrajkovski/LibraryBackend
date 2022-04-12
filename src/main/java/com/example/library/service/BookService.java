package com.example.library.service;

import com.example.library.api.dto.BookDto;
import com.example.library.model.entity.Author;
import com.example.library.model.entity.Book;
import com.example.library.model.enumeration.Category;
import com.example.library.model.exception.AuthorNotFoundException;
import com.example.library.model.exception.BookAlreadyExistsException;
import com.example.library.model.exception.BookNotFoundException;
import com.example.library.model.exception.BookOutOfCopiesException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Optional<Book> findBook(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Optional<Book> addBook(BookDto bookDto) throws Exception {
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        if(bookDto.getName() == null || bookDto.getName().equals(""))
            throw new InvalidNameException();

        if(bookDto.getAvailableCopies() == null || bookDto.getAvailableCopies() <0)
            throw new Exception();

        Category category = Category.valueOf(bookDto.getCategory().toString());

        if(bookRepository.existsByName(bookDto.getName()))
            throw new BookAlreadyExistsException(bookDto.getName());

        Book book = new Book(bookDto.getName(),category,author,bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Transactional
    public Optional<Book> edit(Long id, BookDto bookDto) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        if(bookDto.getName() == null || bookDto.getName().equals(""))
            throw new InvalidNameException();

        if(bookDto.getAvailableCopies() == null || bookDto.getAvailableCopies() < 0)
            throw new Exception();

        Category category = Category.valueOf(bookDto.getCategory().toString());

        if(bookRepository.existsByName(bookDto.getName()) && !Objects.equals(book.getName(), bookDto.getName()))
            throw new BookAlreadyExistsException(bookDto.getName());

        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(book.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Transactional
    public Optional<Book> mark(Long id) throws BookNotFoundException, BookOutOfCopiesException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies()<1){
            throw new BookOutOfCopiesException(id);
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Transactional
    public Optional<Book> delete(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
        return Optional.of(book);
    }
}
