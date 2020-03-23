package br.com.espatodea.postAPI.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;

import org.springframework.lang.Nullable;

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
	
	private String post_content;
	
	private String title;
	
	private Integer post_likes;
	
	@GeneratedValue
	private Integer post_id;
	
	private Integer post_category;
	
	private String post_author;
	
	private Date post_date;
	
}
