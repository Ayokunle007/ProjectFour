package com.ProjectFour.MyProjectfour.Controller;

import com.ProjectFour.MyProjectfour.Model.Books;
import com.ProjectFour.MyProjectfour.Model.BorrowedBooks;
import com.ProjectFour.MyProjectfour.Model.Users;
import com.ProjectFour.MyProjectfour.Service.BookService;
import com.ProjectFour.MyProjectfour.Service.BorrowedBooKService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    public BookService bookService;
    @Autowired
    public BorrowedBooKService borrowedBooKService;

    @GetMapping("/{id}")
        public ResponseEntity<Books> getBookById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
        }
    @GetMapping("/title/{title}")
    public List<Books> getByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }
    @GetMapping("/isbn/{isbnNo}")
    public List<Books> getByIsbnNo(@PathVariable String isbnNo) {
        return bookService.findBookByIsbnNo(isbnNo);
    }
    @GetMapping("")
    public ResponseEntity<List<Books>> getAllBooks() {
        return new ResponseEntity<> (bookService.getAllBooks(), HttpStatus.OK);
    }
   @PostMapping("")
    public ResponseEntity<Books> addBook(@RequestBody @Valid Books books) {
       return new ResponseEntity<>(bookService.addBook(books), HttpStatus.CREATED);
   }
   @PostMapping("/borrow")
   public ResponseEntity<BorrowedBooks> borrowBook(@RequestBody @Valid BorrowedBooks borrowedBooks) {
       return new ResponseEntity<>(borrowedBooKService.addBorrowedBooks(borrowedBooks), HttpStatus.CREATED);
   }
    @GetMapping("/borrowed/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksById(@PathVariable int id) {
        return new ResponseEntity<>(borrowedBooKService.findBorrowedBooksById(id), HttpStatus.OK);
    }

    @GetMapping("/borrowed-bookAuthor/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBookByAuthor(@PathVariable String bookAuthor) {
        return new ResponseEntity<>(borrowedBooKService.findBorrowedBooksByAuthorName(bookAuthor), HttpStatus.OK);
    }

    @GetMapping("/borrowed-bookName/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksByName(@PathVariable String bookName) {
        return new ResponseEntity<>(borrowedBooKService.findBorrowedBooksByBooKName(bookName), HttpStatus.OK);
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteBook(@PathVariable int id) {
       return ResponseEntity.ok(bookService.deleteBook(id));
   }
}

