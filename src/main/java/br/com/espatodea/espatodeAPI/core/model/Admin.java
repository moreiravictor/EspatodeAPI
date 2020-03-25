package br.com.espatodea.espatodeAPI.core.model;

import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
	
	@GeneratedValue
	private int id;
	
	private String username;
	
	private String password;
}