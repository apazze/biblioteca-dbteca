package com.example.dbteca.controller;

import com.example.dbteca.entity.Livro;
import com.example.dbteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(path = "/inserir")
    public Livro Adicionar(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @GetMapping
    public Livro BuscaPorIsbn(@RequestParam String isbn){
        return livroRepository.findByIsbn(isbn);
    }
}
