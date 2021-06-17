package com.cursoudemy.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.workshopmongo.domain.Post;
import com.cursoudemy.workshopmongo.services.PostService;

//Anotação indicando um Recurso REST
@RestController
//Caminho do endpoint
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	PostService service;
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
		Post obj = service.findById(id);
	
		return ResponseEntity.ok().body(obj);

	}
	
}
