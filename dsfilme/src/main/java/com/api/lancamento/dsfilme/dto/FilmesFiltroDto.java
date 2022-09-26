package com.api.lancamento.dsfilme.dto;

import java.io.Serializable;

import com.api.lancamento.dsfilme.entities.Filmes;

public class FilmesFiltroDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String genero;
	
	public FilmesFiltroDto() {}

//	public FilmesFiltroDto(String titulo, String genero) {
//		this.titulo = titulo;
//		this.genero = genero;
//	}
	public FilmesFiltroDto(String titulo) {
		this.titulo = titulo;	
	}
	
	public FilmesFiltroDto(Filmes filmesFilterDto) {
		titulo = filmesFilterDto.getTitulo();
//		genero = filmesFilterDto.getGenero();
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
		
	
}
