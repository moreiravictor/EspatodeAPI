package br.com.espatodea.espatodeAPI.core.model;

import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Post{
	
	private String post_image_path;
	
	private String post_content;
	
	private String title;
	
	private Integer post_likes;
	
	@GeneratedValue
	private Integer post_id;
	
	private List<Category> post_categories;
	
	private String post_author;
	
	private Date post_date = new Date();
	
	private List<Comment> comments;
	
	public Post(Integer post_id) {
		this.post_id = post_id;
	}
	
}
