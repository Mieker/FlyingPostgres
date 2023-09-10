package com.mieker.FlyingPostgres.controller;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return ResponseEntity.ok(customerService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<Customer>> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(customerService.getUser(userId));
    }

    @GetMapping("/redis/{userId}")
    public ResponseEntity<Customer> getAllUsersFromRedis(@PathVariable Long userId) {
        return ResponseEntity.ok(customerService.getUserFromRedis(userId));
    }
}
