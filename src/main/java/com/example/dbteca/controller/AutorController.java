package com.example.dbteca.controller;

import com.example.dbteca.entity.Autor;
import com.example.dbteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/inserir")
    public Autor Adicionar(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }
}
