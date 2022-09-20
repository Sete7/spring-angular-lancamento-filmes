package com.api.lancamento.dsfilme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lancamento.dsfilme.entities.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {

}
