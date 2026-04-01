package com.mongoProject.pkg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoProject.pkg.domain.User;

@Repository //acesso ao banco
public interface UserRepository extends MongoRepository<User, String>{
	
}
