package com.api.lancamento.dsfilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lancamento.dsfilme.entities.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {

}
