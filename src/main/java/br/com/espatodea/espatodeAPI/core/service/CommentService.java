package br.com.espatodea.espatodeAPI.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CommentEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.CommentMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.CommentRepository;
import br.com.espatodea.espatodeAPI.core.model.Comment;

@Service
public class CommentService {

	@Autowired
	CommentRepository repo;
	
	public Comment persist(Comment comment, Integer id) {
		PostEntity post = PostEntity.builder().post_id(id).build();
		CommentEntity entity = CommentMapper.marshall(comment);
		entity.setPost(post);
		return CommentMapper.unmarshall(repo.save(entity));
		
	}
}
