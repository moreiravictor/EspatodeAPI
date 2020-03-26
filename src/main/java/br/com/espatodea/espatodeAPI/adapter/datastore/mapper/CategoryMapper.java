package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CategoryEntity;
import br.com.espatodea.espatodeAPI.core.model.Category;

public class CategoryMapper {

	public static CategoryEntity marshall(Category category) {
		return CategoryEntity
				.builder()
				.category_description(category.getCategory_description())
				.category_id(category.getCategory_id())
				.build();
	}
	
	
	public static List<CategoryEntity> marshall(List<Category> category) {
		return category.stream()
				.map(c -> CategoryMapper.marshall(c))
				.collect(Collectors.toList());

	}
	
	public static Category unmarshall(CategoryEntity entity) {
		return Category
				.builder()
				.category_description(entity.getCategory_description())
				.category_id(entity.getCategory_id())
				.build();
	}
	
	public static List<Category> unmarshall(List<CategoryEntity> category) {
		return category.stream()
				.map(c -> CategoryMapper.unmarshall(c))
				.collect(Collectors.toList());

	}
}
