package com.example.dbteca.controller;

import com.example.dbteca.dto.LivroDto;
import com.example.dbteca.entity.Livro;
import com.example.dbteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping(path = "/inserir")
    public Livro Adicionar(@RequestBody LivroDto livroDto) {
        return livroService.Adicionar(livroDto);
    }
    @GetMapping
    public Optional<Livro> BuscarPorIsbn(@RequestParam String isbn){
        return livroService.BuscarPorIsbn(isbn);
    }
}
