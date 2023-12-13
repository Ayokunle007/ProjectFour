package com.ProjectFour.MyProjectfour.Service;

import com.ProjectFour.MyProjectfour.Model.Books;
import com.ProjectFour.MyProjectfour.Repository.BookRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    @CacheEvict(value = "addBooks", allEntries = true)
    public Books addBook(Books books) {
        return bookRepository.save(books);
    }
    @Cacheable("allBooks")
    public List <Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @CacheEvict(value = "allBooks", allEntries = true)
    public Books borrowBook(int id) {
        return bookRepository.findById(id).orElseThrow(null);
    }
    @CacheEvict(value= "allBooks", allEntries = true)
    public Books deleteBook(int id) {
        Books books = findBookById(id);
        bookRepository.delete(books);
        return books;
    }
    public Books findBookById(int id) {
        return bookRepository.findById(id).orElseThrow(null);
    }
    public List<Books> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Books> findBookByIsbnNo(String isbnNo) {
        return bookRepository.findByIsbnNo(isbnNo);
    }
}
