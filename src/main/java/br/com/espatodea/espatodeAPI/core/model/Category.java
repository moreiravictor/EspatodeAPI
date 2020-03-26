package br.com.espatodea.espatodeAPI.core.model;
import javax.persistence.Id;

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
public class Category {
	
	@Id
	private int category_id;
	
	private String category_description; 
}
