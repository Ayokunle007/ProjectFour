package com.ProjectFour.MyProjectfour.Repository;

import com.ProjectFour.MyProjectfour.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer > {
    List<Books>findByTitle(String title);
    List<Books>findByIsbnNo(String isbnNo);
}
