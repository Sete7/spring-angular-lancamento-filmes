package com.api.lancamento.dsfilme.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.lancamento.dsfilme.dto.FilmesDto;
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
	public ResponseEntity<Page<FilmesDto>> listarDtoTitulo(@RequestParam(name = "titulo") String titulo,
			Pageable pageable) {
		Page<FilmesDto> dto = filmesService.listarDtoTitulo(titulo.trim().toUpperCase(), pageable);
		return new ResponseEntity<Page<FilmesDto>>(dto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Filmes> create(@RequestBody Filmes obj) {
		obj = filmesService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Filmes> buscaPorId(@PathVariable Long id) {
		Filmes obj = filmesService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FilmesDto> editar(@PathVariable Long id, @RequestBody FilmesDto dto) {
		Filmes obj = filmesService.atualizarFilme(id, dto);
		return ResponseEntity.ok(new FilmesDto(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		filmesService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
