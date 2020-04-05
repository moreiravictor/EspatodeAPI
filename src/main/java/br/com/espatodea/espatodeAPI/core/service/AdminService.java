package br.com.espatodea.espatodeAPI.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.AdminEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.AdminMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.AdminRepository;
import br.com.espatodea.espatodeAPI.core.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	
	public Admin getAdmin(String username, String password) throws ResponseStatusException{
		
		AdminEntity entity= repo.findByUsernameAndPassword(username, password);
		if (entity == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong combination");
		}
		
		return AdminMapper.unmarshall(entity);
	}
}
