package com.mieker.FlyingPostgres.repository;

import com.mieker.FlyingPostgres.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
}
