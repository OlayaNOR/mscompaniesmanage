package com.eam.mscompaniesmanage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Data 
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uin;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String country;

    @Column(length = 255)
    private String address;
}
