package com.example.dbteca.dto;

public class LivroDto {
    private String titulo;
    private String isbn;
    private AutorDto autorDto;
    public AutorDto getAutorDto() {
        return autorDto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }
}
