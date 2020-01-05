package br.com.espatodea.postAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.postAPI.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
