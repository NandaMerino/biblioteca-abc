package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	//SALVAR
	public String save(Editora editora) {
		this.editoraRepository.save(editora);
		return "Editora " + editora.getNome() + " cadastrada com sucesso!";
	}
	
	//ALTERAR
	public String update(long id, Editora editora) {
		editora.setId(id);
		this.editoraRepository.save(editora);
		return "Editora alterada com sucesso!";
	}
	
	//LISTAR TODAS AS EDITORAS CADASTRADAS
	public List<Editora>listAll(){
		return this.editoraRepository.findAll();
	}
	
	//LISTAR EDITORA DE ACORDO COM ID SELECIONADO
	public Editora findById(long id) {
		Editora editora = this.editoraRepository.findById(id).get();
		return editora;
	}
	
	//DELETAR
	public String delete(long id) {
		this.editoraRepository.deleteById(id);
		return "Cadastro deletado com sucesso!";
	}

}
