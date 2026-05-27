package com.ppfranco.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppfranco.projeto01.PK.ItemPedidoPK;
import com.ppfranco.projeto01.entidades.ItemPedido;

public interface ItemPedidoRepositories extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
