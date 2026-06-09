package com.ppfranco.projeto01.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.dto.PedidoDTO;
import com.ppfranco.projeto01.entidades.Pedido;

import com.ppfranco.projeto01.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoRecurso {
	
	
	@Autowired
	private PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> findAll(){
		List<Pedido> pedidos = servico.findAll();
		List<PedidoDTO> listDto = pedidos.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
		Pedido obj = servico.findById(id);
		PedidoDTO dto = new PedidoDTO(obj);
		return ResponseEntity.ok().body(dto);
		
		
	}

}
