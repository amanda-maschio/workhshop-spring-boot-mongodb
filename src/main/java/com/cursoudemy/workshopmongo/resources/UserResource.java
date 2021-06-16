package com.cursoudemy.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.workshopmongo.domain.User;
import com.cursoudemy.workshopmongo.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		List<UserDTO> listDTO = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			User user = list.get(i);
			UserDTO userDTO = new UserDTO();

			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());

			listDTO.add(userDTO);
		}
		
		// Expressão lambda alternativa para a conversão da list<User> para list<UserDTO>
		// list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
}
