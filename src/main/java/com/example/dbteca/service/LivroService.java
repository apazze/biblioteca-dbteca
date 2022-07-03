package com.example.dbteca.service;

import com.example.dbteca.dto.LivroDto;
import com.example.dbteca.entity.Autor;
import com.example.dbteca.entity.Livro;
import com.example.dbteca.mapper.LivroMapper;
import com.example.dbteca.repository.AutorRepository;
import com.example.dbteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }
    public Livro Adicionar(LivroDto livroDto){
        Livro livro = LivroMapper.ParaLivro(livroDto);
        if(livroRepository.findByIsbn(livro.getIsbn()).isPresent()){
            throw new IllegalArgumentException("Isbn ja existe!!!!!!!!");
        }
        Optional<Autor> autor = autorRepository.findByNome(livroDto.getAutorDto().getNome());
        if(autor.isPresent()){
            livro.setAutor(autor.get());
        }
        return livroRepository.save(livro);
    }
    public Optional<Livro> BuscarPorIsbn(String isbn){
        return livroRepository.findByIsbn(isbn);
    }
}
