package com.example.dbteca.controller;

import com.example.dbteca.entity.Autor;
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
    public Autor Adicionar(@RequestBody Autor autor){
        if(autorRepository.findByNome(autor.getNome()).isPresent()){
            throw new IllegalArgumentException("Nome ja existe no banco. Tente outro!");
        }
        return autorRepository.save(autor);
    }
    @GetMapping("/{id}")
    public Optional<Autor> BuscarPorId(@PathVariable("id") Long id){
        return autorRepository.findById(id);
    }
}
