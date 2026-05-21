package com.ppfranco.projeto01.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.repositories.UserRepositories;

@Service
public class UserServico {
	
	@Autowired
	private UserRepositories repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
		
	}

}
