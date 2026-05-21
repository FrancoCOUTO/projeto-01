package com.ppfranco.projeto01.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.servicos.UserServico;

@RestController
@RequestMapping(value = "/user")
public class UserRecurso {
	
	@Autowired
	private UserServico servico;

	@GetMapping
	public ResponseEntity<List<User>> findall() {
		List<User> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);

	}

}
