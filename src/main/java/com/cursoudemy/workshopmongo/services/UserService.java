package com.cursoudemy.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.workshopmongo.domain.User;
import com.cursoudemy.workshopmongo.dto.UserDTO;
import com.cursoudemy.workshopmongo.repository.UserRepository;
import com.cursoudemy.workshopmongo.services.exception.ObjectNotFoundException;

//@SERVICE - Registra um serviço que poderá ser injetado em outras classes
@Service
public class UserService {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
