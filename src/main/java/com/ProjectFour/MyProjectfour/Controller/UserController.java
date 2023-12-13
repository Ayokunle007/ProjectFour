package com.ProjectFour.MyProjectfour.Controller;

import com.ProjectFour.MyProjectfour.Model.BorrowedBooks;
import com.ProjectFour.MyProjectfour.Model.Users;
import com.ProjectFour.MyProjectfour.Service.BorrowedBooKService;
import com.ProjectFour.MyProjectfour.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/fullName/{fullName}")
    public List<Users> getByFullName(@PathVariable String fullName) {
        return userService.findByFullName(fullName);
    }
    @GetMapping("/email/{email}")
    public List<Users> getByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("")
    public ResponseEntity<Users> addUser(@RequestBody @Valid Users users) {
        return new ResponseEntity<>(userService.addUser(users), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @Valid @RequestBody Users users) {
        return ResponseEntity.ok(userService.updateUser(id, users));
    }

}
