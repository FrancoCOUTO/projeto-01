package com.ppfranco.projeto01.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.dto.CategoriaDTO;
import com.ppfranco.projeto01.entidades.Categoria;
import com.ppfranco.projeto01.servicos.CategoriaServico;



@RestController
@RequestMapping(value = "/categoria")
public class CategoriaRecurso {
	
	@Autowired
	private CategoriaServico servico;
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> lista = servico.findAll();
		List<CategoriaDTO> listDto = lista.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
		Categoria obj = servico.findById(id);
		CategoriaDTO dto = new CategoriaDTO(obj);
		return ResponseEntity.ok().body(dto);
	}
	

	
	
}
