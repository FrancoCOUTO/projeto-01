package com.ppfranco.projeto01.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ppfranco.projeto01.entidades.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;

	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido obj) {
		id = obj.getId();
		moment = obj.getMoment();
				
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	

}
