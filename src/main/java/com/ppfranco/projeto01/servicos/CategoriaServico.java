package com.ppfranco.projeto01.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppfranco.projeto01.entidades.Categoria;
import com.ppfranco.projeto01.repositories.CategoriaRepositories;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositories repositorio;
	
	
	public List<Categoria> findAll(){
		 return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
	

}
