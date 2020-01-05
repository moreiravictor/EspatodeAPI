package br.com.espatodea.postAPI.adapter.datastore.mapper;

import br.com.espatodea.postAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.postAPI.core.model.Post;

public class PostMapper {
	
	public static PostEntity marshall(Post model) {
		return PostEntity.builder().content(model.getContent()).
				id(model.getId()).likes(model.getLikes()).title(model.getTitle())
				.author(model.getAuthor()).category(model.getCategory()).date(model.getDate()).build();
	}
	
	
	public static Post unmarshall(PostEntity entity) {
		return Post.builder().content(entity.getContent()).
				id(entity.getId()).likes(entity.getLikes()).title(entity.getTitle())
				.author(entity.getAuthor()).category(entity.getCategory()).date(entity.getDate()).build();
	}
}
