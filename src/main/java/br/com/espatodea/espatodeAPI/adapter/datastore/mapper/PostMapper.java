package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import java.util.stream.Collectors;

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
				.post_category(model.getPost_category())
				.post_date(model.getPost_date())
				.comments(model.getComments()
							.stream()
							.map(x -> CommentMapper.marshall(x))
							.collect(Collectors.toList())
						)
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
				.comments(entity.getComments()
							.stream()
							.map(x -> CommentMapper.unmarshall(x))
							.collect(Collectors.toList())
						)
				.build();
	}
}