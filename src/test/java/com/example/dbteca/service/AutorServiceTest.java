package com.example.dbteca.service;

import com.example.dbteca.entity.Autor;
import com.example.dbteca.mapper.AutorMapper;
import com.example.dbteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
class AutorServiceTest {
    @Autowired
    private AutorService autorService;
    @MockBean
    private AutorRepository autorRepository;

    @Test
    void NaoDeveCadastrarAutorExistente() {
        Autor autor = new Autor("autor");
        autorService.Adicionar(AutorMapper.ParaAutorDto(autor));
    }

}