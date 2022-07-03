package com.example.dbteca.service;

import com.example.dbteca.dto.AutorDto;
import com.example.dbteca.entity.Autor;
import com.example.dbteca.mapper.AutorMapper;
import com.example.dbteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    public Autor Adicionar(AutorDto autorDto){
        Optional<Autor> autor = autorRepository.findByNome(autorDto.getNome());
        if (autor.isPresent()) {
            throw new IllegalArgumentException("Nome do Autor ja existe!!!!!!!!");
        }
        return autorRepository.save(AutorMapper.ParaAutor(autorDto));
    }
    public Optional<Autor> BuscarPorId(Long id){
        return autorRepository.findById(id);
    }
}