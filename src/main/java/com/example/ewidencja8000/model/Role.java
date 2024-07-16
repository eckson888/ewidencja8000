package com.example.ewidencja8000.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
