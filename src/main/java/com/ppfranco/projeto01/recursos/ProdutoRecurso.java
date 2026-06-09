package com.ppfranco.projeto01.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.dto.ProdutoDTO;
import com.ppfranco.projeto01.entidades.Produto;
import com.ppfranco.projeto01.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoRecurso {

	@Autowired
	private ProdutoServico servico;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> listaP = servico.findAll();
		List<ProdutoDTO> listDto = listaP.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		Produto obj = servico.findById(id);
		ProdutoDTO dto = new ProdutoDTO(obj);
		return ResponseEntity.ok().body(dto);

	}

}
