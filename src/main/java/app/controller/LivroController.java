package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController

@RequestMapping("/api/livro")
public class LivroController {
	@Autowired
	private LivroService livroService;
	
	//SALVAR
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Livro livro){
		try {
			String mensagem = this.livroService.save(livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao tentar salvar o cadastro", HttpStatus.BAD_REQUEST);
		}
	}
	
	//ALTERAR
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Livro livro, @PathVariable long id){
		try {
			String mensagem = this.livroService.update(id, livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar alterar: "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>>listAll(){
		try {
			List<Livro>lista = this.livroService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID
	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro>findById(@PathVariable long id){
		try {
			Livro livro = this.livroService.findById(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//DELETAR
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable long id){
		try {
			String mensagem = this.livroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar deletar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

}
