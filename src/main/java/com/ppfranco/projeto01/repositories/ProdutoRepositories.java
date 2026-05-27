package com.ppfranco.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppfranco.projeto01.entidades.Produto;

public interface ProdutoRepositories extends JpaRepository<Produto, Long> {

}
