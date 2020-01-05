package br.com.espatodea.postAPI.adapter.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.postAPI.core.model.Post;
import br.com.espatodea.postAPI.core.service.PostService;


@RestController
@RequestMapping("post")
public class PostController {

	@Autowired
	PostService service = new PostService();
	
	@PostMapping("/publish")
	public Post post(@RequestBody Post model) {
		return service.persist(model);
	}
	
	@GetMapping("/getAll")
	public List<Post> listAll() {
		
		return service.list();
	}
	
}
