package com.ppfranco.projeto01.recursos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.entidades.Produto;
import com.ppfranco.projeto01.servicos.ProdutoServiso;





@RestController
@RequestMapping(value = "/produto")
public class ProdutoRecurso {
	
	@Autowired
	private ProdutoServiso servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> listaP = servico.findAll();
		return ResponseEntity.ok().body(listaP);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
