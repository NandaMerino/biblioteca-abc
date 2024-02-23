package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Livro {
	private long id;
	private String issn;
	private String titulo;
	private String sinopse;
	private int ano;
	private int num_pagina;
}
