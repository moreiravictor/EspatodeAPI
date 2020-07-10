package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CategoryEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

	List<PostEntity> findByTitleContaining(String title);
	
	List<PostEntity> findByPostCategories(CategoryEntity category);
}
