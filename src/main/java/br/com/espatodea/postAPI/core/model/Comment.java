package br.com.espatodea.postAPI.core.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Comment {

	private int comment_id;
	
	private String comment_content;
	
	private	String comment_author;
	
	private Date comment_date;
	
	private int comment_like;
}
