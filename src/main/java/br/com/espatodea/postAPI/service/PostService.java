package br.com.espatodea.postAPI.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Post> list() {
		List<Post> postList = new ArrayList<>(); 
		List<PostEntity> entityList = repo.findAll();
		for (PostEntity entity : entityList) {
			postList.add(PostMapper.unmarshall(entity));
		}
		return postList;
	}
}
