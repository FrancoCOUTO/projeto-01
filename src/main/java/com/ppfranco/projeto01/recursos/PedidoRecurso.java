package com.ppfranco.projeto01.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppfranco.projeto01.entidades.Pedido;
import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoRecurso {
	
	
	@Autowired
	private PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> pedidos = servico.findAll();
		return ResponseEntity.ok().body(pedidos);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

}
