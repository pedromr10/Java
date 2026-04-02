package com.mongoProject.pkg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoProject.pkg.domain.Post;

@Repository //acesso ao banco
public interface PostRepository extends MongoRepository<Post, String>{
	
}
