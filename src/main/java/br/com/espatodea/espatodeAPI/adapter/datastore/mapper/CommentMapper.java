package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CommentEntity;
import br.com.espatodea.espatodeAPI.core.model.Comment;

public class CommentMapper {

	public static CommentEntity marshall(Comment comment) {
		return CommentEntity.builder()
				.comment_author(comment.getComment_author())
				.comment_content(comment.getComment_content())
				.comment_date(comment.getComment_date())
				.comment_like(comment.getComment_like())
				.build();
	}
	
	public static Comment unmarshall(CommentEntity entity) {
		return Comment.builder()
				.comment_author(entity.getComment_author())
				.comment_content(entity.getComment_content())
				.comment_date(entity.getComment_date())
				.comment_like(entity.getComment_like())
				.comment_id(entity.getComment_id())
				.post_id(entity.getPost().getPost_id())
				.build();
	}
	
}
