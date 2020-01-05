package br.com.espatodea.postAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espatodea.postAPI.entity.PostEntity;
import br.com.espatodea.postAPI.mapper.PostMapper;
import br.com.espatodea.postAPI.model.Post;
import br.com.espatodea.postAPI.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repo;
	
	public Post persist(Post model) {
		PostEntity entity = repo.save(PostMapper.marshall(model));
		return PostMapper.unmarshall(entity);
	}
}
