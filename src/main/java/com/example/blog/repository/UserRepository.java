package com.example.blog.repository;

import com.example.blog.model.User;
import java.util.List;
import java.util.Optional;

import java.sql.SQLException;

public interface UserRepository {
    User createUser(User user) throws SQLException;

    Optional<User> getUserById(String id) throws SQLException;
    Optional<User> getUserByUsername(String username) throws SQLException;
    Optional<User> getUserByEmail(String email) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    User updateUser(String id, User user) throws SQLException;
    void deleteUser(String id) throws SQLException;
        
}
