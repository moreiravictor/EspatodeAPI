package br.com.espatodea.espatodeAPI.adapter.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.espatodea.espatodeAPI.core.model.Admin;
import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
import br.com.espatodea.espatodeAPI.core.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminService service = new AdminService();
	
	@GetMapping("/get")
	public HttpReturn<Admin> userMatches(@RequestBody Admin admin) {
		return new HttpReturn<Admin>(service.getAdmin(admin), HttpStatus.FOUND);
	}

}
