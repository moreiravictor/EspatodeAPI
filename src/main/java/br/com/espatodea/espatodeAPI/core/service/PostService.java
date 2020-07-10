package br.com.espatodea.espatodeAPI.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CategoryEntity;
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
		post.setPost_date(new Date());
		post.getComments().forEach(x -> x.setComment_date(new Date()));
		PostEntity entity = PostMapper.marshall(post); 
 		if (post.getComments() != null) {
 			entity.getComments().forEach(x -> x.setPost(entity));
 		}
		repo.save(entity);
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
		List<PostEntity> entityList = repo.findByTitleContaining(title);
		for (PostEntity entity : entityList) {
			postList.add(PostMapper.unmarshall(entity));
		}
		return postList;
	}
	
	public Post findById(Integer id) throws ResponseStatusException {
		Optional<PostEntity> optionalEntity = repo.findById(id);
		if(!optionalEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		} 
		return PostMapper.unmarshall(optionalEntity.get());
	}
	
	public List<Post> findByCategory(Integer category_id) throws ResponseStatusException {
		CategoryEntity cat_ent = new CategoryEntity();
		cat_ent.setCategory_id(category_id);
		List<PostEntity> entityList = repo.findByPostCategories(cat_ent);
		if(entityList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts within this category");
		}
		List<Post> postList = new ArrayList<Post>();
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
		entity.setPostCategories((model.getPost_categories() != null) ? CategoryMapper.marshall(model.getPost_categories()) : entity.getPostCategories());
		entity.setPost_author((model.getPost_author() != null) ? model.getPost_author() : entity.getPost_author());
		entity.setTitle((model.getTitle() != null) ? model.getTitle() : entity.getTitle());
		entity.setPost_content((model.getPost_content() != null) ? model.getPost_content() : entity.getPost_content());
		entity.setPost_image_path((model.getPost_image_path() != null) ? model.getPost_image_path() : entity.getPost_image_path());

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
