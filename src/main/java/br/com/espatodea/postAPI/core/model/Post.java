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

	
	private String content;
	private String title;
	private Integer likes;
	@GeneratedValue
	private Integer id;
	private Integer category;
	private String author;
	private Date date;
}
