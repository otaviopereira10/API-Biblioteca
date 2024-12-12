package com.projeto.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.entity.Livro;
import com.projeto.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	 @Autowired
	    private LivroRepository livroRepository;

	    public LivroService(LivroRepository livroRepository) {
	        this.livroRepository = livroRepository;
	    }

	    public List<Livro> getAllLivro() {
	        return livroRepository.findAll();
	    }

	    public Livro getLivroById(Long id) {
	        Optional<Livro> existingLivro = livroRepository.findById(id);
	        return existingLivro.orElse(null);
	    }

	    public Livro createLivro(Livro livro) {
	        return livroRepository.save(livro);
	    }

	    public Livro updateLivro(Long id, Livro updatedLivro) {
	        Optional<Livro> existingLivro = livroRepository.findById(id);
	        if (existingLivro.isPresent()) {
	            updatedLivro.setId(id);
	            return livroRepository.save(updatedLivro);
	        }
	        return null;
	    }

	    public boolean deleteLivro(Long id) {
	        Optional<Livro> existingLivro = livroRepository.findById(id);
	        if (existingLivro.isPresent()) {
	            livroRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}



