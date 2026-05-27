package com.ppfranco.projeto01.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppfranco.projeto01.entidades.Produto;
import com.ppfranco.projeto01.repositories.ProdutoRepositories;

@Service
public class ProdutoServiso {
	
	@Autowired
	private ProdutoRepositories repositorio;
	
	
	public List<Produto> findAll(){
		return repositorio.findAll();
		
	}
	
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

}
