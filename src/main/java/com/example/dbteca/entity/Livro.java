package com.example.dbteca.entity;

import javax.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String isbn;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autor", joinColumns = {@JoinColumn(name = "livro_id")}, inverseJoinColumns = {@JoinColumn(name = "autor_id")})
    private Autor autor;

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }
}
