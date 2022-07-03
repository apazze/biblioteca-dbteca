package com.example.dbteca.controller;

import com.example.dbteca.dto.AutorDto;
import com.example.dbteca.entity.Autor;
import com.example.dbteca.mapper.AutorMapper;
import com.example.dbteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/inserir")
    public Autor Adicionar(@RequestBody AutorDto autorDto){
        Optional<Autor> autor = autorRepository.findByNome(autorDto.getNome());
        if(autor.isPresent()){
            throw new IllegalArgumentException("Autor ja existe!!!!!!!!");
        }
        return autorRepository.save(AutorMapper.ParaAutor(autorDto));
    }
    @GetMapping
    public Optional<Autor> BuscarPorId(@RequestParam Long id){
        return autorRepository.findById(id);
    }
}
