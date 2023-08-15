package com.mieker.FlyingPostgres.service;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }
}
