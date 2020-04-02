package br.com.espatodea.espatodeAPI.core.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CommentEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.CommentMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.CommentRepository;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.PostRepository;
import br.com.espatodea.espatodeAPI.core.model.Comment;
import br.com.espatodea.espatodeAPI.core.model.Post;

@Service
public class CommentService {

	@Autowired
	CommentRepository repo;
	
	@Autowired
	PostRepository postRepo;
	
	public Comment persist(Comment comment, Integer post_id) throws ResponseStatusException {
		if (!postRepo.findById(post_id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post does not exist");
		}
		comment.setComment_date(new Date());
		PostEntity post = PostEntity.builder().post_id(post_id).build();
		CommentEntity entity = CommentMapper.marshall(comment);
		entity.setPost(post);
		return CommentMapper.unmarshall(repo.save(entity));
	}
	
	public Comment delete(Integer id) throws ResponseStatusException {
		if (!repo.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
		}
		repo.deleteById(id);
		return new Comment();
	}
	
	public List<Comment> getCommentsByPost(Integer id_post)	throws ResponseStatusException {
		List<Comment> comments = repo.findByPost(new PostEntity(id_post))
									.stream()
									.map(post -> CommentMapper.unmarshall(post))
									.collect(Collectors.toList());
		
		if (comments.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No comment on this post");
		}
		
		return comments;
	}
}
