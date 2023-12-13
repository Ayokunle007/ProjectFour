package com.ProjectFour.MyProjectfour.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "library_books")

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_title")
    @Length(min = 10, max = 40, message = "Enter the book title")
    private String title;

    @Length(min = 6, max = 15, message = "Enter the first and last name")
    private String author;

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String isbnNo;

    @Column(name= "publication_year")
    private int publicationYear;

    public Books(String title, String author, String isbnNo, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbnNo = isbnNo;
        this.publicationYear = publicationYear;
    }
}
