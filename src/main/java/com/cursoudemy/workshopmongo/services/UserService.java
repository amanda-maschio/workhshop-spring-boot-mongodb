package com.cursoudemy.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.workshopmongo.domain.User;
import com.cursoudemy.workshopmongo.repository.UserRepository;

//@SERVICE - Registra um serviço que poderá ser injetado em outras classes
@Service
public class UserService {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
