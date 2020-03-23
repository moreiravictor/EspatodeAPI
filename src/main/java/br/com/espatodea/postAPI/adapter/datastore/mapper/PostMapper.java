package br.com.espatodea.postAPI.adapter.datastore.mapper;

import br.com.espatodea.postAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.postAPI.core.model.Post;

public class PostMapper {
	
	public static PostEntity marshall(Post model) {
		return PostEntity.builder()
				.post_content(model.getPost_content())
				.post_id(model.getPost_id())
				.post_likes(model.getPost_likes())
				.title(model.getTitle())
				.post_author(model.getPost_author())
				.post_category(model.getPost_category())
				.post_date(model.getPost_date())
				.build();
	}
	
	
	public static Post unmarshall(PostEntity entity) {
		return Post.builder()
				.post_content(entity.getPost_content())
				.post_id(entity.getPost_id())
				.post_likes(entity.getPost_likes())
				.title(entity.getTitle())
				.post_author(entity.getPost_author())
				.post_category(entity.getPost_category())
				.post_date(entity.getPost_date())
				.build();
	}
}
