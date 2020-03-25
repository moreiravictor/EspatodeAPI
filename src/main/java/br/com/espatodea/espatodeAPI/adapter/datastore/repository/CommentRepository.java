
package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CommentEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.entity.PostEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

	List<CommentEntity> findByPost(PostEntity post);
	
}
