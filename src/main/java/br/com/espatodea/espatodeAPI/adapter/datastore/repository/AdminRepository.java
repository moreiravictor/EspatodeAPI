package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {
	
	AdminEntity findByUsernameAndPassword(String username, String password);

}
