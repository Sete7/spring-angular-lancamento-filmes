package com.api.lancamento.dsfilme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.lancamento.dsfilme.entities.Filmes;
import com.api.lancamento.dsfilme.services.FilmesService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmesController {
	
	@Autowired
	private FilmesService filmesService;
	
	@GetMapping
	public List<Filmes> listar(){
		return filmesService.listar();
	}

}
