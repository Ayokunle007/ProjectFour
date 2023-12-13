package com.ProjectFour.MyProjectfour.Service;

import com.ProjectFour.MyProjectfour.Model.Books;
import com.ProjectFour.MyProjectfour.Model.BorrowedBooks;
import com.ProjectFour.MyProjectfour.Model.Users;
import com.ProjectFour.MyProjectfour.Repository.BookRepository;
import com.ProjectFour.MyProjectfour.Repository.BorrowedBookRepository;
import com.ProjectFour.MyProjectfour.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BorrowedBooKService {
    private BorrowedBookRepository borrowedBookRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    @CacheEvict(value = "addBorrowedBooks", allEntries = true)
    public BorrowedBooks addBorrowedBooks(BorrowedBooks borrowedBooks) {
        Books books = bookRepository.findById(borrowedBooks.getBooks().getId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Users users = userRepository.findById(borrowedBooks.getUsers().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        borrowedBooks.setBooks(books);
        borrowedBooks.setUsers(users);

        return borrowedBookRepository.save(borrowedBooks);
    }
    public BorrowedBooks findBorrowedBooksById(int id) {
        return borrowedBookRepository.findById(id).orElseThrow(null);
    }

    public BorrowedBooks findBorrowedBooksByAuthorName(String bookAuthor) {
        return (BorrowedBooks) borrowedBookRepository.findByBookAuthor(bookAuthor);
    }
    public BorrowedBooks findBorrowedBooksByBooKName(String bookName) {
        return (BorrowedBooks) borrowedBookRepository.findByBookName(bookName);
    }
}
