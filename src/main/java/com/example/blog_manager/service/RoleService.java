package com.example.blog_manager.service;

import com.example.blog_manager.model.Role;

public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
