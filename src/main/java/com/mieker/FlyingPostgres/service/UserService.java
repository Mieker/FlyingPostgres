package com.mieker.FlyingPostgres.service;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Customer> getUser(Long id) {
        return userRepository.findById(id);
    }

    @PostConstruct
    public void createInitialData() {
        Customer customer1 = new Customer(1L, "Maciek", "Z Klanu", "maciek@wp.pl");
        Customer customer2 = new Customer(2L, "Arnold", "Boczek", "boczek@wp.pl");
        userRepository.save(customer1);
        userRepository.save(customer2);
    }
}
