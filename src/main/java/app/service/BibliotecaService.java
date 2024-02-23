package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Biblioteca;

@Service
public class BibliotecaService {
	List<Biblioteca>lista = new ArrayList<>();
	
	
	//SALVAR
	public String save(Biblioteca biblioteca) {
		lista.add(biblioteca);
		return biblioteca.getNome() + " cadastrada com sucesso!";
	}
	
	//ALTERAR
	public String update(Biblioteca biblioteca) {
		lista = this.listAll();
		
		if(lista != null) {
			for (int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == biblioteca.getId()) {
					lista.set(i, biblioteca);
					return biblioteca.getNome() + " alterado com sucesso!";
				}
			}
		}
		return "Biblioteca não encontrado para alterar";
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	public List<Biblioteca>listAll(){
		Biblioteca biblioteca = new Biblioteca(1, "Biblioteca Municipal", "(45) 3333-3333");
		Biblioteca biblioteca2 = new Biblioteca(2, "Biblioteca Infantil", "(00) 7777-7777");
		Biblioteca biblioteca3 = new Biblioteca(3, "Biblioteca Universitária", "(55) 9999-9999");
		
		lista.add(biblioteca);
		lista.add(biblioteca2);
		lista.add(biblioteca3);
		
		
		return lista;
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID SELECIONADO
	public Biblioteca findById(long id) {
		lista = this.listAll();
		if(lista != null) {
			for (int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == id) {
					return lista.get(i);
				}
			}
		}
		return null;
	}
	
	//DELETAR CADASTRO
	public String delete(long id) {
		lista = this.listAll();
		if(lista != null) {
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == id) {
					lista.remove(lista.get(i));
					return "Cadastro deletado com sucesso!";
				}
			}
		}
		return "Biblioteca não encontrado para deletar";
	}

}
