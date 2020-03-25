package br.com.espatodea.espatodeAPI.core.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpReturn<T> {
		
	private T data;
	private HttpStatus httpStatus;
	
	public HttpReturn(T returnObject, HttpStatus requestStatus) {
		this.data = returnObject;
		this.httpStatus = requestStatus;
	}
}
