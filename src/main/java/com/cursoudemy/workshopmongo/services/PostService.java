package com.cursoudemy.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.workshopmongo.domain.Post;
import com.cursoudemy.workshopmongo.repository.PostRepository;
import com.cursoudemy.workshopmongo.services.exception.ObjectNotFoundException;

//@SERVICE - Registra um serviço que poderá ser injetado em outras classes
@Service
public class PostService {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
