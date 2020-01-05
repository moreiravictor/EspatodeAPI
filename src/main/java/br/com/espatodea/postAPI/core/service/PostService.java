package br.com.espatodea.postAPI.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espatodea.postAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.postAPI.adapter.datastore.mapper.PostMapper;
import br.com.espatodea.postAPI.adapter.datastore.repository.PostRepository;
import br.com.espatodea.postAPI.core.model.Post;



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
