package com.example.dbteca.dto;

public class LivroDto {
    private String titulo;
    private String isbn;
    private AutorDto autorDto;

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorDto getAutorDto() {
        return autorDto;
    }
}
