package com.ProjectFour.MyProjectfour.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity(name =" borrowed_books")
@Getter
@Setter
@NoArgsConstructor
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    @Length( min= 5, max= 40, message= "Enter the name of book")
    private String bookName;

    @Column(name = "book_author")
    @Length( min = 6, max = 20, message = "Enter Author's name")
    private String bookAuthor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books;

    public BorrowedBooks(String bookName, String bookAuthor, Users users, Books books) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.users = users;
        this.books = books;
    }
}
