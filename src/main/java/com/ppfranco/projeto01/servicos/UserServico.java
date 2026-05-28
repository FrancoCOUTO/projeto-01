package com.ppfranco.projeto01.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.repositories.UserRepositories;
import com.ppfranco.projeto01.servicos.exception.DataErrorExepition;
import com.ppfranco.projeto01.servicos.exception.ResourseNotFoundExeption;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServico {

	@Autowired
	private UserRepositories repository;

	public List<User> findAll() {
		return repository.findAll();

	}

	public User findById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourseNotFoundExeption(id));
	}

	public User insert(User obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourseNotFoundExeption(id);
		}
		try {
		repository.deleteById(id);
		
		}catch(DataIntegrityViolationException e) {
			throw new DataErrorExepition(e.getMessage());
		
		}

	}
	@Transactional
	public User update(Long id, User obj) {
		
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity , obj);
		return repository.save(entity);
		
		}catch(EntityNotFoundException e) {
			throw new ResourseNotFoundExeption(id);
		}
		
		
	}
	
	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
		
		
	}

}
