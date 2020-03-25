package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.AdminEntity;
import br.com.espatodea.espatodeAPI.core.model.Admin;

public class AdminMapper {

	public static AdminEntity marshall(Admin admin) {
		return AdminEntity
				.builder()
				.username(admin.getUsername())
				.password(admin.getPassword())
				.id(admin.getId())
				.build();
	}
	
	public static Admin unmarshall(AdminEntity entity) {
		return Admin
				.builder()
				.username(entity.getUsername())
				.password(entity.getPassword())
				.id(entity.getId())
				.build();
	}
	
}
