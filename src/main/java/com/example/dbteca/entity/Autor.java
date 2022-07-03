package com.example.dbteca.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "autor")
    private List<Livro> publicacoes;
    public Autor() {
    }
    public Autor(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public List<Livro> getPublicacoes() {
        return publicacoes;
    }
}
