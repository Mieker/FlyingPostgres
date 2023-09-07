package com.mieker.FlyingPostgres.service;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.repository.UserRedisRepository;
import com.mieker.FlyingPostgres.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserRedisRepository redisRepository;

    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Customer> getUser(Long id) {
        Customer customerFromCache = redisRepository.findById(id);
        if (null == customerFromCache) {
            Optional<Customer> customerFromDb = userRepository.findById(id);
            customerFromDb.ifPresent(redisRepository::save);
            log.info("Customer from Postgres SQL database.");
            return customerFromDb;
        }
        log.info("Customer from Redis cache.");
        return Optional.ofNullable(redisRepository.findById(id));
    }

    public Customer getUserFromRedis(Long id) {
        return redisRepository.findById(id);
    }

    @PostConstruct
    public void createInitialData() {
        Customer customer1 = new Customer(1L, "Maciek", "Z Klanu", "maciek@wp.pl");
        Customer customer2 = new Customer(2L, "Arnold", "Boczek", "boczek@wp.pl");
        Customer customer3 = new Customer(3L, "Regina", "Red", "red@wp.pl");
        userRepository.save(customer1);
        userRepository.save(customer2);
        userRepository.save(customer3);
    }
}
