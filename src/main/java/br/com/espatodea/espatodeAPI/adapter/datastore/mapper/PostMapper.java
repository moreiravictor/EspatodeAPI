package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.core.model.Post;

public class PostMapper {
	
	public static PostEntity marshall(Post model) {
		return 	PostEntity.builder()
				.post_content(model.getPost_content())
				.post_id(model.getPost_id())
				.post_likes(model.getPost_likes())
				.title(model.getTitle())
				.post_author(model.getPost_author())
				.post_image_path(model.getPost_image_path())
				.post_categories((model.getPost_categories() != null) ? CategoryMapper.marshall(model.getPost_categories()) : null)
				.post_date(model.getPost_date())
				.comments((model.getComments() != null) ? CommentMapper.marshall(model.getComments()) : null)
				.build();
	}
	
	
	public static Post unmarshall(PostEntity entity) {
		return Post.builder()
				.post_content(entity.getPost_content())
				.post_id(entity.getPost_id())
				.post_likes(entity.getPost_likes())
				.title(entity.getTitle())
				.post_author(entity.getPost_author())
				.post_image_path(entity.getPost_image_path())
				.post_categories((entity.getPost_categories() != null) ? CategoryMapper.unmarshall(entity.getPost_categories()) : null)
				.post_date(entity.getPost_date())
				.comments((entity.getComments() != null) ? CommentMapper.unmarshall(entity.getComments()) : null)
				.build();
	}
}
