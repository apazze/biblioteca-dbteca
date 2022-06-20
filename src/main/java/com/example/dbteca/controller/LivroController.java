package com.example.dbteca.controller;

import com.example.dbteca.entity.Livro;
import com.example.dbteca.repository.AutorRepository;
import com.example.dbteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/inserir")
    public Livro Adicionar(@RequestBody Livro livro) {
        if(autorRepository.findByNome(livro.getAutor().getNome()).isPresent()){
            throw new IllegalArgumentException("Nome ja existe no banco. Tente outro!");
        }
        return livroRepository.save(livro);
    }
    @GetMapping
    public Livro BuscaPorIsbn(@RequestParam String isbn){
        return livroRepository.findByIsbn(isbn);
    }
}
