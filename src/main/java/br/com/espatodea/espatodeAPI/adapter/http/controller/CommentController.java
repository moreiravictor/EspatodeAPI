package br.com.espatodea.espatodeAPI.adapter.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.espatodeAPI.core.model.Comment;
import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
import br.com.espatodea.espatodeAPI.core.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	@PostMapping("/publish")
	public HttpReturn<Comment> postComment(@RequestBody Comment comment) {
		return new HttpReturn<Comment>(service.persist(comment, comment.getPost_id()), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpReturn<Comment> deleteComment(@PathVariable Integer id) {
		return new HttpReturn<Comment>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/getCommentsByPost/{id_post}")
	public HttpReturn<List<Comment>> getComments(@PathVariable Integer id_post) {
		return new HttpReturn<List<Comment>>(service.getCommentsByPost(id_post), HttpStatus.OK);
	}
}
