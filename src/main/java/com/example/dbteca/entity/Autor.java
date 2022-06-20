package com.example.dbteca.entity;

import javax.persistence.*;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
