package com.example.dbteca.repository;

import com.example.dbteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Livro findByIsbn(String isbn);
}
