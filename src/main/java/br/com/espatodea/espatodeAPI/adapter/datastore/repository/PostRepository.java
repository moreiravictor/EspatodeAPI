package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;
import br.com.espatodea.espatodeAPI.core.model.Post;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

	List<PostEntity> findByTitle(String title);
}
