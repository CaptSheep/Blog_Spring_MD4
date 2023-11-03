package com.example.blog_manager.service.impl;

import com.example.blog_manager.model.Role;
import com.example.blog_manager.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public Role findByName(String name) {
        return null;
    }
}
