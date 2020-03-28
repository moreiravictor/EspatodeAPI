package br.com.espatodea.espatodeAPI.adapter.datastore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "categories")
public class CategoryEntity {
	
	@Id
	private int category_id;
	
	@ManyToMany(mappedBy = "post_categories", fetch = FetchType.EAGER)
	private List<PostEntity> posts;
	
	private String category_description;
	
	public CategoryEntity(int category_id) {
		this.category_id = category_id;
	}
}
