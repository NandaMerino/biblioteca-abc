package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {
	List<Livro>lista = new ArrayList<>();
	
	//SALVAR
	public String save(Livro livro) {
		lista.add(livro);
		return "Livro " + livro.getTitulo() + " cadastrado com sucesso!";
	}
	
	//ALTERAR
	public String update(Livro livro) {
		lista = this.listAll();
		
		if(lista!= null) {
			for (int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == livro.getId()) {
					lista.set(i, livro);
					return "Livro " + livro.getTitulo() + " alterado com sucesso!";
				}
			}
		}
		return "Livro não encontrado para alterar";
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	public List<Livro>listAll(){
		Livro livro = new Livro(1, "F92UM", "ABC", "Aprendendo o alfabeto",2000, 333);
		Livro livro2 = new Livro(2, "LKDN6", "123", "Aprendendo matemática", 2001, 700);
		Livro livro3 = new Livro(2, "NAKJ9", "Receitas", "Receitas de pães", 2024, 500);
		
		lista.add(livro);
		lista.add(livro2);
		lista.add(livro3);
		
		return lista;
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID SELECIONADO
	public Livro findById(long id) {
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
	
	//DELETAR
	public String delete(long id) {
		lista = this.listAll();
		if(lista!= null) {
			for (int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == id) {
					lista.remove(lista.get(i));
					return "Cadastro deletado com sucesso!";
				}
			}
		}
		return "Cadastro não encontrado para deletar";
	}

}
