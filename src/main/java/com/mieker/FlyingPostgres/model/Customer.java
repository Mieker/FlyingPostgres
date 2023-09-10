package com.mieker.FlyingPostgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate joinDate;

}
