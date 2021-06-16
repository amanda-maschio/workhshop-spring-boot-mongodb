package com.cursoudemy.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	//Não necessita criar implementação dessa interface
	//MongoRepository já tem uma implementação padrão para essa interface
}
