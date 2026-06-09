package com.ppfranco.projeto01.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ppfranco.projeto01.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findall() {
		List<User> lista = servico.findAll();
		List<UserDTO> listaDto = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable long id) {
		User obj = servico.findById(id);
		UserDTO userDto = new UserDTO(obj);
		return ResponseEntity.ok().body(userDto);
	}

	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto) {
		User obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update (@PathVariable Long id, @RequestBody UserDTO objDto){
		User obj = servico.fromDTO(objDto);
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}
	

}
