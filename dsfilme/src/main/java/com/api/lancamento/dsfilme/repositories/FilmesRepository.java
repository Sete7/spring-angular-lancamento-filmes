package com.api.lancamento.dsfilme.repositories;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.lancamento.dsfilme.entities.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {

	@Query("SELECT obj FROM Filmes obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.titulo DESC")
	Page<Filmes> findFilmes(LocalDate min, LocalDate max, Pageable pageable);
	
	@Query("SELECT f FROM Filmes f WHERE upper(trim(f.titulo)) like %?1% ORDER BY f.titulo DESC")
	Page<Filmes> listarDtoTitulo(String titulo, Pageable pageable);



}
