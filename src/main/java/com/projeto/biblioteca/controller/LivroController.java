package com.projeto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.biblioteca.entity.Livro;
import com.projeto.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livro")
@CrossOrigin(origins = "*")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@GetMapping
	public List<Livro> getAllLivro() {
		return livroService.getAllLivro();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
		return ResponseEntity.ok(livroService.getLivroById(id));
	}

	@PostMapping
	public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
		return ResponseEntity.ok(livroService.createLivro(livro));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> updateLivro(@PathVariable Long id,
			@RequestBody Livro updatedLivro) {
		return ResponseEntity.ok(livroService.updateLivro(id, updatedLivro));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
		return ResponseEntity.noContent().build();
	}
}
