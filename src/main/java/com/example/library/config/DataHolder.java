package com.example.library.config;

import com.example.library.model.entity.Author;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Country;
import com.example.library.model.enumeration.Category;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataHolder {

    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();
    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;
    public final CountryRepository countryRepository;

    @PostConstruct
    public void init() {
        Country c1 = new Country("Norway","Europe");
        Country c2 = new Country("Senegal","Africa");
        Country c3 = new Country("New York","North America");
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countryRepository.saveAll(countries);

        Author a1 = new Author("David","Trajkovski",c1);
        Author a2 = new Author("Marija","Stojcheva",c2);
        Author a3 = new Author("Ana","Trajkovska",c3);
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authorRepository.saveAll(authors);

        Book b1 = new Book("Petar Pan", Category.FANTASY,a1,10);
        Book b2 = new Book("Zoki Poki", Category.DRAMA,a2,20);
        Book b3 = new Book("Crnila", Category.BIOGRAPHY,a3,50);
        Book b4 = new Book("Kletnici", Category.NOVEL,a1,100);
        Book b5 = new Book("Zlostorstvo i kazna", Category.THRILLER,a1,300);
        Book b6 = new Book("Proces", Category.HISTORY,a2,500);
        Book b7 = new Book("Serdarot", Category.CLASSICS,a3,1000);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        bookRepository.saveAll(books);
    }

}
