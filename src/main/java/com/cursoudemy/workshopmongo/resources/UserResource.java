package com.cursoudemy.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.workshopmongo.domain.User;
import com.cursoudemy.workshopmongo.services.UserService;

//Anotação indicando um Recurso REST
@RestController
//Caminho do endpoint
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
}
