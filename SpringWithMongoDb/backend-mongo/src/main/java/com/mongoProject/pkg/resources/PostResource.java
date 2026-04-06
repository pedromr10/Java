package com.mongoProject.pkg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongoProject.pkg.domain.Post;
import com.mongoProject.pkg.resources.util.URL;
import com.mongoProject.pkg.services.PostService;

@RestController //resource ou controller - recebe requisicoes
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	//retorna o post desejado, pelo id:
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postService.findById(id); 
		return ResponseEntity.ok().body(post);
	}
	
	//retorna os posts que contem uma palavra:
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
		//para testar: http://localhost:8080/posts/titlesearch?text=bom%20dia
	}
	
}
