package br.com.espatodea.espatodeAPI.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.CategoryMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.PostMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.PostRepository;
import br.com.espatodea.espatodeAPI.core.model.Post;

@Service
public class PostService {
	
	@Autowired
	PostRepository repo;
	
	public Post persist(Post post) {
		PostEntity entity = PostMapper.marshall(post); 
 		entity.getComments().forEach(x -> x.setPost(entity));
		return PostMapper.unmarshall(repo.save(entity));
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
	
	public Post att(Post model, Integer id) throws ResponseStatusException {
		Optional<PostEntity> optionalEntity = repo.findById(id);
		
		if(!optionalEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		}
		
		PostEntity entity = optionalEntity.get();
		//TODO correct patch of categories
//		entity.setPost_categories(((model.getPost_categories() != null) ? CategoryMapper.marshall(model.getPost_categories()) : entity.getPost_categories()));
		entity.setPost_author((model.getPost_author() != null) ? model.getPost_author() : entity.getPost_author());
		entity.setTitle((model.getTitle() != null) ? model.getTitle() : entity.getTitle());

		return PostMapper.unmarshall(repo.save(entity));	
	}
	
	public Post delete(Integer id) throws ResponseStatusException {
		if (!repo.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		}
		repo.deleteById(id);
		return new Post();
	}
}
