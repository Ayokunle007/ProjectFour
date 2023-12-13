package com.ProjectFour.MyProjectfour.Service;

import com.ProjectFour.MyProjectfour.Model.Users;
import com.ProjectFour.MyProjectfour.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @CacheEvict(value = "allUsers", allEntries = true)
    public Users addUser(Users users) {
        return userRepository.save(users);
    }
    @Cacheable("allUsers")
    public List <Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users findUserById(int id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public List<Users> findByFullName(String fullName) {
        return userRepository.findByFullName(fullName);
    }
    public List<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @CacheEvict(value ="allUsers", allEntries = true)
    public Users deleteUser(int id) {
        Users users = findUserById(id);
        userRepository.delete(users);
        return users;
    }

    @CacheEvict(value ="allUsers", allEntries = true)
    public String updateUser(int id, Users users) {
        Users toUpdate = findUserById(id);

        toUpdate.setFullName(users.getFullName());
        toUpdate.setEmail(users.getEmail());
        toUpdate.setAge(users.getAge());
        toUpdate.setAddress(users.getAddress());
        userRepository.save(toUpdate);
        return "Users successfully updated";
    }

}
