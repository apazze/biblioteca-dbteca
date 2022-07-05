package com.example.dbteca.service;

import com.example.dbteca.entity.Autor;
import com.example.dbteca.mapper.AutorMapper;
import com.example.dbteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AutorServiceTest {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private AutorService autorService;

    @Test
    void NaoDeveCadastrarAutorExistente() {
        Autor autor = new Autor("autor");
        autorService.Adicionar(AutorMapper.ParaAutorDto(autor));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> autorService.Adicionar(AutorMapper.ParaAutorDto(autor)));
        assertEquals("Nome do Autor ja existe!!!!!!!!", exception.getMessage());
    }

}