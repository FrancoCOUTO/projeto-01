package com.ppfranco.projeto01.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.servicos.UserServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable long id) {
		User obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping(value = "/{id}")
	private ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	

}
