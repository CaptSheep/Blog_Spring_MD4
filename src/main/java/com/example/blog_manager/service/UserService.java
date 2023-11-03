package com.example.blog_manager.service;

import com.example.blog_manager.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {
    void save(User user);

    Iterable<User> findAll();

    User findByUsername(String username);

    User getCurrentUser();

    Optional<User> findById(Long id);

    UserDetails loadUserById(Long id);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);
}
