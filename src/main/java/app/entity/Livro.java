package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String issn;
	private String titulo;
	private String sinopse;
	private int ano;
	private int num_pagina;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livros")
	private Biblioteca biblioteca;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livros")
	private Editora editora;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="autor_livro")
	private List<Autor> autores;
	
}