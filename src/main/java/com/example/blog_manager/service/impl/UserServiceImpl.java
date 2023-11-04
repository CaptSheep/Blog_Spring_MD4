package com.example.blog_manager.service.impl;

import com.example.blog_manager.model.User;
import com.example.blog_manager.repository.IUserRepository;
import com.example.blog_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return null;
    }

    @Override
    public boolean checkLogin(User user) {
        return false;
    }

    @Override
    public boolean isRegister(User user) {
        return false;
    }

    @Override
    public boolean isCorrectConfirmPassword(User user) {
        boolean checked = false;
        if(user.getPassword().equals(user.getCheckPassword())){
            checked = true;
        }
        return checked;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
