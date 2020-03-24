package br.com.espatodea.postAPI.adapter.datastore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private int comment_id;
	
//	@ManyToOne
//	@JoinColumn(name = "post_id", referencedColumnName = "post_id")
//	private PostEntity post;
	
	@Column(name = "comment_content")
	private String comment_content;
	
	@Column(name = "comment_author")
	private	String comment_author;
	
	@Column(name = "comment_date")
	private Date comment_date;
	
	@Column(name = "comment_like")
	private int comment_like;
}
