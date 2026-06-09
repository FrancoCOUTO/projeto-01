package com.ppfranco.projeto01.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppfranco.projeto01.dto.PedidoDTO;
import com.ppfranco.projeto01.entidades.Pedido;

import com.ppfranco.projeto01.repositories.PedidoRepositories;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositories repositorio;
	

	public List<Pedido> findAll(){
		return repositorio.findAll();
		
	}
	public Pedido findById(Long id) {
		Optional <Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Pedido fromDTO(PedidoDTO objDto) {
		Pedido pedido = new Pedido();
		pedido.setId(objDto.getId());
		pedido.setMoment(objDto.getMoment());
		return pedido;
	}
} 

