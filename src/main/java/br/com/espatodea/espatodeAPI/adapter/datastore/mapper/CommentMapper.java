package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<CommentEntity> marshall(List<Comment> comment) {
		return comment.stream()
				.map(c -> CommentMapper.marshall(c))
				.collect(Collectors.toList());
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
	
	public static List<Comment> unmarshall(List<CommentEntity> entity) {
		return entity.stream()
				.map(c -> CommentMapper.unmarshall(c))
				.collect(Collectors.toList());
	}
	
}
