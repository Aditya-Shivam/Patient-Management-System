package com.pm.authservice.service;

import com.pm.authservice.repo.UserRepo;
import com.pm.authservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo  userRepo;
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
