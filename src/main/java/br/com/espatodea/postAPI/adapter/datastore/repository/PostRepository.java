package br.com.espatodea.postAPI.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.postAPI.adapter.datastore.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
