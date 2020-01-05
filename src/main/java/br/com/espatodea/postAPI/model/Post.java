package br.com.espatodea.postAPI.model;

import java.util.Date;

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
public class Post {
	private String content;
	private String title;
	private int likes;
	private int id;
	private int category;
	private String author;
	private Date date;
}
