package com.mieker.FlyingPostgres.configuration;

import com.mieker.FlyingPostgres.model.Customer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    @Bean
    public RedisTemplate<Long, Customer> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Customer> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

}