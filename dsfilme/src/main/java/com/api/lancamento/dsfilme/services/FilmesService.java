package com.api.lancamento.dsfilme.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.lancamento.dsfilme.dto.FilmesDto;
import com.api.lancamento.dsfilme.entities.Filmes;
import com.api.lancamento.dsfilme.repositories.FilmesRepository;

@Service
public class FilmesService {

	@Autowired
	private FilmesRepository filmesRepository;

	@Transactional
	public Filmes create(Filmes obj) {
		Filmes filmes = filmesRepository.save(obj);
		return filmes;
	}

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

	public Optional<Filmes> buscaPorid(Long id) {
		Optional<Filmes> obj = filmesRepository.findById(id);
		return obj;
	}

	public Filmes findById(Long id) {
		Optional<Filmes> obj = filmesRepository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException(" Objeto não encontrado! código: " + id, Filmes.class.getName()));
	}

	public Filmes atualizarFilme(Long id, FilmesDto dto) {
		Filmes obj = findById(id);
//		obj.setCodigo(dto.getCodigo());
		obj.setTitulo(dto.getTitulo());
		obj.setGenero(dto.getGenero());
		obj.setNota(dto.getNota());
		obj.setUrlFoto(dto.getUrlFoto());
		obj.setUrlImdb(dto.getUrlImdb());
		obj.setDescricao(dto.getDescricao());
		return filmesRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			filmesRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.api.lancamento.dsfilme.service.exceptions.DataIntegrityViolationException(
					"Filmes não pode ser deletado!");
		}
	}

}
