package com.example.dbteca.mapper;

import com.example.dbteca.dto.AutorDto;
import com.example.dbteca.entity.Autor;

public class AutorMapper {
    public static Autor ParaAutor(AutorDto autorDto) {
        return new Autor(autorDto.getNome());
    }
}
