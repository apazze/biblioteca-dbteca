package com.example.dbteca.controller;

import com.example.dbteca.entity.Autor;
import com.example.dbteca.entity.Livro;
import com.example.dbteca.repository.AutorRepository;
import com.example.dbteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/inserir")
    public Livro Adicionar(@RequestBody Livro livro) {
        Optional<Autor> autor = autorRepository.findByNome(livro.getAutor().getNome());
        if(autor.isPresent()){
            livro.setAutor(autor.get());
        }
        return livroRepository.save(livro);
    }
    @GetMapping
    public Livro BuscaPorIsbn(@RequestParam String isbn){
        return livroRepository.findByIsbn(isbn);
    }
}
