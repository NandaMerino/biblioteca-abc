package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;

@Service
public class AutorService {
	List<Autor>lista = new ArrayList<>();
	
	//SALVAR
	public String save(Autor autor) {
		lista.add(autor);
		return "Autor " + autor.getNome() + " cadastrado com sucesso!";
	}
	
	//ALTERAR
	public String update(Autor autor) {
		lista = this.listAll();
		
		if(lista != null) {
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == autor.getId()) {
					lista.set(i, autor);
					return "Cadastro de autor(a)" + autor.getNome() + " alterado com sucesso!";
				}
			}
		}
		return "Autor não encontrado para alterar";
	}
	
	//LISTAR TODOS OS AUTORES CADASTRADOS
	public List<Autor>listAll(){
		Autor autor = new Autor(1, "Maria", "000.000.000-00", 86);
		Autor autor2 = new Autor(2, "Joana", "111.111.111-11", 53);
		Autor autor3 = new Autor(3, "João", "333.333.333-33", 27);
		
		lista.add(autor);
		lista.add(autor2);
		lista.add(autor3);
		
		return lista;
	}
	
	//LISTAR DE ACORDO COM ID SELECIONADO
	public Autor findById(long id) {
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
		if(lista != null) {
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == id) {
					lista.remove(lista.get(i));
					return "Cadastro deletado com sucesso!";
				}
			}
		}
		return "Cadastro não encontrado para deletar";
	}

}
