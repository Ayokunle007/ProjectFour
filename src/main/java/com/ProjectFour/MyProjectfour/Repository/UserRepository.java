package com.ProjectFour.MyProjectfour.Repository;

import com.ProjectFour.MyProjectfour.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

   List <Users> findByFullName(String fullName);
    List <Users> findByEmail(String email);
}
