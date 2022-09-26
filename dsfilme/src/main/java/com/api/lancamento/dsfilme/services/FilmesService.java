package com.api.lancamento.dsfilme.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.lancamento.dsfilme.dto.FilmesDto;
import com.api.lancamento.dsfilme.dto.FilmesFiltroDto;
import com.api.lancamento.dsfilme.entities.Filmes;
import com.api.lancamento.dsfilme.repositories.FilmesRepository;

@Service
public class FilmesService {

	@Autowired
	private FilmesRepository filmesRepository;

	public Page<Filmes> listar(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		return filmesRepository.findFilmes(min, max, pageable);
	}

	public Page<FilmesDto> listarDtoTitulo(String titulo, Pageable pageable) {	
		Page<Filmes> obj = filmesRepository.listarDtoTitulo(titulo, pageable);
		return obj.map(x -> new FilmesDto(x));
	}

	public Page<FilmesDto> listarDto(Pageable pageable) {
		Page<Filmes> obj = filmesRepository.findAll(pageable);
		return obj.map(x -> new FilmesDto(x));
	}

}
