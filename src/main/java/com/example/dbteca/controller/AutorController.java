package com.example.dbteca.controller;

import com.example.dbteca.dto.AutorDto;
import com.example.dbteca.entity.Autor;
import com.example.dbteca.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping(path = "/inserir")
    public Autor Adicionar(@RequestBody AutorDto autorDto) {
        return autorService.Adicionar(autorDto);
    }

    @GetMapping
    public Optional<Autor> BuscarPorId(@RequestParam Long id) {
        return autorService.BuscarPorId(id);
    }
}