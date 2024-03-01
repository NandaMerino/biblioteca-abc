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

import app.entity.Autor;
import app.service.AutorService;

@RestController

@RequestMapping("/api/autor")

public class AutorController {
	@Autowired
	private AutorService autorService;

	// SALVAR
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Autor autor) {
		try {
			String mensagem = this.autorService.save(autor);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao tentar salvar o cadastro!", HttpStatus.BAD_REQUEST);
		}
	}

	// ALTERAR
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Autor autor, @PathVariable long id) {
		try {
			String mensagem = this.autorService.update(id, autor);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar alterar o cadastro: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	// LISTAR TODOS AUTORES CADASTRADOS
	@GetMapping("/listAll")
	public ResponseEntity<List<Autor>> listAll() {
		try {
			List<Autor> lista = this.autorService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// LISTAR AUTOR PELO ID
	@GetMapping("/findById/{id}")
	public ResponseEntity<Autor> findById(@PathVariable long id) {
		try {
			Autor autor = this.autorService.findById(id);
			return new ResponseEntity<>(autor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// DELETAR
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.autorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu este erro ao tentar deletar: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);

		}
	}

}
