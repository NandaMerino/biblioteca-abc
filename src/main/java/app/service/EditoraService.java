package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Editora;

@Service
public class EditoraService {
	List<Editora>lista = new ArrayList<>();
	
	//SALVAR
	public String save(Editora editora) {
		lista.add(editora);
		return "Editora " + editora.getNome() + " cadastrada com sucesso!";
	}
	
	//ALTERAR
	public String update(Editora editora) {
		lista = this.listAll();
		
		if(lista != null) {
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == editora.getId()) {
					lista.set(i, editora);
					return "Editora " + editora.getNome() + " alterado com sucesso!";
				}
			}
		}
		return "Editora não encontrada para alterar";
	}
	
	//LISTAR TODAS AS EDITORAS CADASTRADAS
	public List<Editora>listAll(){
		Editora editora = new Editora(1, "Lua", "Rua 3, número 7", "(11) 1234-1234");
		Editora editora2 = new Editora(2, "Nuvem", "Rua Tempestate, número 25", "(45) 7777-7777");
		Editora editora3 = new Editora(3, "Jupiter", "Rua Via Lactea, número 1000", "(00) 0000-0000");
		
		lista.add(editora);
		lista.add(editora2);
		lista.add(editora3);
		
		return lista;
	}
	
	//LISTAR EDITORA DE ACORDO COM ID SELECIONADO
	public Editora findById(long id) {
		lista = this.listAll();
		if(lista != null) {
			for(int i=0; i<lista.size(); i++) {
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
					return "Cadastro de editora deletado com sucesso!";
				}
			}
		}
		return "Editora não encontrada para deletar";
	}

}
