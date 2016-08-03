package com.projectmaking.Service;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User printUser(){
        Long id =repository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        return repository.findOne(id) ;
    }
    public HttpStatus register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.saveAndFlush(user);
        return HttpStatus.CREATED;
    }
    public HttpStatus deleteAccount(){
        Long id =repository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        repository.delete(id);
        return HttpStatus.NO_CONTENT;
    }

}
