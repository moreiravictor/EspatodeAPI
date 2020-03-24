
package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

}
