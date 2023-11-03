package com.example.blog_manager.service.impl;

import com.example.blog_manager.model.Role;
import com.example.blog_manager.repository.IRoleRepository;
import com.example.blog_manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public Role findByName(String name) {
        return iRoleRepository.findByName(name);
    }
}
