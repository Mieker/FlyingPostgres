package com.mieker.FlyingPostgres.repository;

import com.mieker.FlyingPostgres.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRedisRepository {

    @Autowired
    private RedisTemplate<Long, Customer> redisTemplate;

    public void save(Customer customer) {
        redisTemplate.opsForValue()
            .set(customer.getId(), customer);
    }

    public Customer findById(Long id) {
        return redisTemplate.opsForValue()
            .get(id);
    }

}