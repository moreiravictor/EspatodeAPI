package br.com.espatodea.espatodeAPI.adapter.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.espatodeAPI.core.model.Post;
import br.com.espatodea.espatodeAPI.core.service.PostService;
import javassist.NotFoundException;

@CrossOrigin
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
	
	@GetMapping("/getByTitle")
	public List<Post> listByTitle(@RequestParam String title) {
		return service.findByTitle(title);
	}
	
	@PatchMapping("/patch/{id}")
	public Post PatchPost(@PathVariable Integer id
							,@RequestBody Post model) throws NotFoundException {
		return service.att(model, id);
	}
}
