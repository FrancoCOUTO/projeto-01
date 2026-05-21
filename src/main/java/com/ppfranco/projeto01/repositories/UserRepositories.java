package com.ppfranco.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppfranco.projeto01.entidades.User;

public interface UserRepositories extends JpaRepository<User, Long> {

}
