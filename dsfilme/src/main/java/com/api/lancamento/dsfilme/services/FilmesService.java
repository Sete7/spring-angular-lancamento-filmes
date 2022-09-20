package com.api.lancamento.dsfilme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.lancamento.dsfilme.entities.Filmes;
import com.api.lancamento.dsfilme.repositories.FilmesRepository;

@Service
public class FilmesService {
	
	@Autowired
	private FilmesRepository filmesRepository;

	public List<Filmes> listar() {		
		return filmesRepository.findAll();
	}
	
	
}
