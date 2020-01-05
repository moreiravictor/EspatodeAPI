package br.com.espatodea.postAPI.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espatodea.postAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.postAPI.adapter.datastore.mapper.PostMapper;
import br.com.espatodea.postAPI.adapter.datastore.repository.PostRepository;
import br.com.espatodea.postAPI.core.model.Post;
import javassist.NotFoundException;



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
	
	public List<Post> findByTitle(String title) {		 
		List<Post> postList = new ArrayList<>(); 
		List<PostEntity> entityList = repo.findByTitle(title);
		for (PostEntity entity : entityList) {
			postList.add(PostMapper.unmarshall(entity));
		}
		return postList;
	}
	
	public Post att(Post model, Integer id) throws NotFoundException {
		Optional<PostEntity> optionalEntity = repo.findById(id);
		
		if(!optionalEntity.isPresent()) {
			throw new NotFoundException(null);
		}
		
		PostEntity entity = optionalEntity.get();
		entity.setAuthor(model.getAuthor());
		entity.setTitle(model.getTitle());

		return PostMapper.unmarshall(repo.save(entity));	
	}
}
