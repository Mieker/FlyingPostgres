package com.mieker.FlyingPostgres.service;

import com.mieker.FlyingPostgres.model.Customer;
import com.mieker.FlyingPostgres.repository.CustomerRedisRepository;
import com.mieker.FlyingPostgres.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerRedisRepository customerRedisRepository;

    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getUser(Long id) {
        long startTime = System.currentTimeMillis();
        long endTime;
        Customer customerFromCache = customerRedisRepository.findById(id);
        if (null == customerFromCache) {
            Optional<Customer> customerFromDb = customerRepository.findById(id);
            customerFromDb.ifPresent(customerRedisRepository::save);
            log.info("Customer from Postgres SQL database.");
            endTime = System.currentTimeMillis();
            log.info(String.valueOf(endTime - startTime));
            return customerFromDb;
        }
        log.info("Customer from Redis cache.");
        endTime = System.currentTimeMillis();
        log.info(String.valueOf(endTime - startTime));
        return Optional.ofNullable(customerRedisRepository.findById(id));
    }

    public Customer getUserFromRedis(Long id) {
        return customerRedisRepository.findById(id);
    }

}
