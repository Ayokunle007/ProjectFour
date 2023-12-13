package com.ProjectFour.MyProjectfour.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "library_user")

public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "full_name")
    @Length(min=6, max = 15, message=" Enter the first and last name")
    private String fullName;

    private int age;

    private String address;

    @Email(message = "Enter valid email")
    private String email;

    public Users(String fullName, int age, String address, String email) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.email = email;
    }
    
}
