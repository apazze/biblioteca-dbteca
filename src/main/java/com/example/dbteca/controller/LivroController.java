package com.example.dbteca.controller;

import com.example.dbteca.dto.LivroDto;
import com.example.dbteca.entity.Livro;
import com.example.dbteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity Adicionar(@RequestBody LivroDto livroDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(livroService.Adicionar(livroDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping
    public Optional<Livro> BuscarPorIsbn(@RequestParam String isbn){
        return livroService.BuscarPorIsbn(isbn);
    }
}
