package br.com.espatodea.espatodeAPI.adapter.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.espatodeAPI.core.model.Comment;
import br.com.espatodea.espatodeAPI.core.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	@PostMapping("/publish_comment")
	public Comment postComment(@RequestBody Comment comment) {
		return service.persist(comment, comment.getPost_id());
	}
}
