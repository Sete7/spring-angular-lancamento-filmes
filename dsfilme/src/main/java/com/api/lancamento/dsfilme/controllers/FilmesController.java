package com.api.lancamento.dsfilme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.lancamento.dsfilme.dto.FilmesDto;
import com.api.lancamento.dsfilme.dto.FilmesFiltroDto;
import com.api.lancamento.dsfilme.entities.Filmes;
import com.api.lancamento.dsfilme.services.FilmesService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmesController {

	@Autowired
	private FilmesService filmesService;

	@GetMapping
	public Page<Filmes> listar(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
		return filmesService.listar(minDate, maxDate, pageable);
	}

	@GetMapping(value = "/listar")
	public ResponseEntity<Page<FilmesDto>> listarDto(Pageable pageable) {
		Page<FilmesDto> dto = filmesService.listarDto(pageable);
		return new ResponseEntity<Page<FilmesDto>>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarTitulo")
	public ResponseEntity<Page<FilmesDto>> listarDtoTitulo(
			@RequestParam(name = "titulo") String titulo,
			Pageable pageable) {
		Page<FilmesDto> dto = filmesService.listarDtoTitulo(
				titulo.trim().toUpperCase(),
				pageable);
		return new ResponseEntity<Page<FilmesDto>>(dto, HttpStatus.OK);
	}

}
