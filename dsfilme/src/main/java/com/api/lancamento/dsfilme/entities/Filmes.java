package com.api.lancamento.dsfilme.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.api.lancamento.dsfilme.dto.FilmesDto;

@Entity
@Table(name = "tb_filmes")
public class Filmes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String titulo;
	private String urlFoto;
	private LocalDate date;
	private LocalDate dtLancamento;
	private String descricao;
	private Double nota;
	private String urlImdb;
	private String genero;

	public Filmes() {
	}

	public Filmes(Long id, String titulo, String urlFoto, LocalDate date, LocalDate dtLancamento,
			String descricao, Double nota, String urlImdb, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.urlFoto = urlFoto;
		this.date = date;
		this.dtLancamento = dtLancamento;
		this.descricao = descricao;
		this.nota = nota;
		this.urlImdb = urlImdb;
		this.genero = genero;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the urlFoto
	 */
	public String getUrlFoto() {
		return urlFoto;
	}

	/**
	 * @param urlFoto the urlFoto to set
	 */
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the dtLancamento
	 */
	public LocalDate getDtLancamento() {
		return dtLancamento;
	}

	/**
	 * @param dtLancamento the dtLancamento to set
	 */
	public void setDtLancamento(LocalDate dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
	}

	/**
	 * @return the urlImdb
	 */
	public String getUrlImdb() {
		return urlImdb;
	}

	/**
	 * @param urlImdb the urlImdb to set
	 */
	public void setUrlImdb(String urlImdb) {
		this.urlImdb = urlImdb;
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

	public FilmesDto map(Filmes object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PrePersist
	public void beforeSave() {
		setDate(LocalDate.now());
	}	

}
