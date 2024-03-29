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

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController

@RequestMapping("/api/biblioteca")
public class BibliotecaController {
	@Autowired
	private BibliotecaService bibliotecaService;
	
	//SALVAR
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Biblioteca biblioteca){
		try {
			String mensagem = this.bibliotecaService.save(biblioteca);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao tentar salvar o cadastro!", HttpStatus.BAD_REQUEST);
		}
	}
	
	//ALTERAR
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Biblioteca biblioteca, @PathVariable long id){
		try {
			String mensagem = this.bibliotecaService.update(id,biblioteca);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar alterar: "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	//LISTAR TODOS OS ITENS CADASTRADOS
	@GetMapping("/listAll")
	public ResponseEntity<List<Biblioteca>>listAll(){
		try {
			List<Biblioteca>lista = this.bibliotecaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//LISTAR ITEM CADASTRADO DE ACORDO COM O ID SELECIONADO
	@GetMapping("/findById/{id}")
	public ResponseEntity<Biblioteca>findById(@PathVariable long id){
		try {
			Biblioteca biblioteca = this.bibliotecaService.findById(id);
			return new ResponseEntity<>(biblioteca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//DELETAR CADASTRO
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable long id){
		try {
			String mensagem = this.bibliotecaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar deletar: "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
	
	
	
	

}
