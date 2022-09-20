package com.api.lancamento.dsfilme.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filmes")
public class Filmes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String urlFoto;
	private LocalDateTime dtLancamento;
	private String descricao;
	private Double nota;
	private String urlImdb;
	private String genero;
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
	 * @return the dtLancamento
	 */
	public LocalDateTime getDtLancamento() {
		return dtLancamento;
	}
	/**
	 * @param dtLancamento the dtLancamento to set
	 */
	public void setDtLancamento(LocalDateTime dtLancamento) {
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
}
