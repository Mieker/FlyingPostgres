package com.mieker.FlyingPostgres.controller;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
