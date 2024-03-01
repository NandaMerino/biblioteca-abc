package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;

@Service
public class BibliotecaService {
	
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	//SALVAR
	public String save(Biblioteca biblioteca) {
		this.bibliotecaRepository.save(biblioteca);
		return biblioteca.getNome() + " cadastrada com sucesso!";
	}
	
	//ALTERAR
	public String update(long id, Biblioteca biblioteca) {
		biblioteca.setId(id);
		this.bibliotecaRepository.save(biblioteca);
		return biblioteca.getNome() + " alterado com sucesso!";
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	public List<Biblioteca>listAll(){
		return this.bibliotecaRepository.findAll();
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID SELECIONADO
	public Biblioteca findById(long id) {
		Biblioteca biblioteca = this.bibliotecaRepository.findById(id).get();
		return biblioteca;
	}
	
	//DELETAR CADASTRO
	public String delete(long id) {
		this.bibliotecaRepository.deleteById(id);
		return "Cadastro deletado com sucesso!";
	}
		

}
