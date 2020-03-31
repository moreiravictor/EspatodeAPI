package br.com.espatodea.espatodeAPI.adapter.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
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
	public HttpReturn<Post> post(@RequestBody Post model) {
		return new HttpReturn<Post>(service.persist(model), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAll")
	public HttpReturn<List<Post>> listAll() {
		
		return new HttpReturn<List<Post>>(service.list(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getByTitle")
	public HttpReturn<List<Post>> listByTitle(@RequestParam String title) {
		return new HttpReturn<List<Post>>(service.findByTitle(title), HttpStatus.FOUND);
	}
	
	@GetMapping("/getById/{id}")
	public HttpReturn<Post> listByTitle(@PathVariable Integer id) {
		return new HttpReturn<Post>(service.findById(id), HttpStatus.FOUND);
	}
	
	@PatchMapping("/patch/{id}")
	public HttpReturn<Post> PatchPost(@PathVariable Integer id
							,@RequestBody Post model) throws NotFoundException {
		return new HttpReturn<Post>(service.att(model, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpReturn<Post> DeletePost(@PathVariable Integer id) throws NotFoundException {
		return new HttpReturn<Post>(service.delete(id), HttpStatus.OK);
	}
}
