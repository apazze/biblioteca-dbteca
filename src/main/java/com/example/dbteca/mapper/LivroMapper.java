package com.example.dbteca.mapper;

import com.example.dbteca.dto.LivroDto;
import com.example.dbteca.entity.Livro;

public class LivroMapper {
    public static Livro ParaLivro(LivroDto livroDto) {
        return new Livro(livroDto.getTitulo(), livroDto.getIsbn(), AutorMapper.ParaAutor(livroDto.getAutorDto()));
    }
}
