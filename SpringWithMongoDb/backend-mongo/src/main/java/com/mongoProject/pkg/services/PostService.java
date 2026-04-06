package com.mongoProject.pkg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoProject.pkg.domain.Post;
import com.mongoProject.pkg.repository.PostRepository;
import com.mongoProject.pkg.services.exception.ObjectNotFoundException;

@Service //logica de negocio
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//retorna o post desejado, pelo id:
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado."));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	
}
