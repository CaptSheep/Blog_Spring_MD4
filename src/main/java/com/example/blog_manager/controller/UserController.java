package com.example.blog_manager.controller;

import com.example.blog_manager.model.Role;
import com.example.blog_manager.model.User;
import com.example.blog_manager.service.impl.RoleServiceImpl;
import com.example.blog_manager.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> listUser(){
      Iterable<User> listUser = userService.findAll();
      return new ResponseEntity<>(listUser,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        Iterable<User> listUser = userService.findAll();
        for(User item : listUser){
            if(item.getUserName().equals(user.getUserName())){
                return new ResponseEntity<>(HttpStatus.SEE_OTHER);
            }
        }
        if (user.getRoles() != null) {
            Role role = roleService.findByName("ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {
            Role role1 = roleService.findByName("ROLE_ADMIN");
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role1);
            user.setRoles(roles1);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCheckPassword(passwordEncoder.encode(user.getCheckPassword()));
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
