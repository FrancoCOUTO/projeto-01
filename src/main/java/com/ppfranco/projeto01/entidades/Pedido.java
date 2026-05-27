package com.ppfranco.projeto01.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.ppfranco.projeto01.enuns.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private User cliente;
	
	private Integer statusPedido;
	
	@OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido() {

	}

	public Pedido(Long id, Instant moment, User cliente , StatusPedido statusPedido) {
		super();
		this.id = id;
		this.moment = moment;
		this.cliente = cliente;
		setStatusPedido(statusPedido);
		
		
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

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	

	public StatusPedido getStatusPedido() {
		return StatusPedido.statusPedido(statusPedido) ;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null) {
		this.statusPedido = statusPedido.getCodigo();
		}
	}
	
	
	public Set<ItemPedido> getItemPedido(){ 
		return itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
