package com.ProjectFour.MyProjectfour.Repository;

import com.ProjectFour.MyProjectfour.Model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBooks, Integer> {
    List<BorrowedBooks> findByBookAuthor(String bookAuthor);
    List<BorrowedBooks> findByBookName(String bookName);
}
