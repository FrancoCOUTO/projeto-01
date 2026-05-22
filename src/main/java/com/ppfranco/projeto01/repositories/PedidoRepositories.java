package com.ppfranco.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppfranco.projeto01.entidades.Pedido;

public interface PedidoRepositories  extends JpaRepository<Pedido, Long>{

}
