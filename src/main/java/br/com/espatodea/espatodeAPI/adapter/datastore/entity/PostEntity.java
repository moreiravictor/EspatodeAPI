package br.com.espatodea.espatodeAPI.adapter.datastore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "posts")
public class PostEntity {

	@Column(name = "post_content")
	private String post_content;
	
	@Column(name = "post_title")
	private String title;
	
	@Column(name = "post_likes")
	private Integer post_likes;
	
	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Integer post_id;
	
	@Column(name = "post_category")
	private int post_category;
	
	@Column(name = "post_author")
	private String post_author;
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@Column(name = "post_date")
	private Date post_date;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CommentEntity> comments; 
	
	public PostEntity(Integer post_id) {
		this.post_id = post_id;
	}
}
