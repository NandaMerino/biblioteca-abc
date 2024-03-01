package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	//SALVAR
	public String save(Livro livro) {
		this.livroRepository.save(livro);
		return "Livro " +livro.getTitulo() + " cadastrado com sucesso!";
	}
	
	//ALTERAR
	public String update(long id, Livro livro) {
		livro.setId(id);
		this.livroRepository.save(livro);
		return "Livro " + livro.getTitulo() + " alterado com sucesso!";
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	public List<Livro>listAll(){
		return this.livroRepository.findAll();
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID SELECIONADO
	public Livro findById(long id) {
		Livro livro = this.livroRepository.findById(id).get();
		return livro;
	}
	
	//DELETAR
	public String delete(long id) {
		this.livroRepository.deleteById(id);
		return "Cadastro deletado com sucesso";
	}

}
