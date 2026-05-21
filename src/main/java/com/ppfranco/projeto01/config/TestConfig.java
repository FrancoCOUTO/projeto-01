package com.ppfranco.projeto01.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.repositories.UserRepositories;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // injeção de dependencia
	private UserRepositories userRepositories;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepositories.saveAll(Arrays.asList(u1, u2));

	}

}
