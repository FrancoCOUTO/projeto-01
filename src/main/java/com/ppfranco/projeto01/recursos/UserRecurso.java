package com.ppfranco.projeto01.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.entidades.User;

@RestController
@RequestMapping(value = "/user")
public class UserRecurso {
	
	@GetMapping
	public ResponseEntity<User> findall(){
		User u = new User(1L, "Maria", "maria@gmail", "999999234", "1234");
		return ResponseEntity.ok().body(u);
		
	}
	

}
