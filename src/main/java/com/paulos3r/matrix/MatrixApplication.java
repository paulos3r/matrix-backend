package com.paulos3r.matrix;

import com.paulos3r.matrix.model.entity.Cliente;
import com.paulos3r.matrix.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MatrixApplication {

	/*@Bean  //testando a base de dados
	public CommandLineRunner rum(@Autowired ClienteRepository repository){
		return args -> {
			Cliente cliente = Cliente.builder()
					.cpf("00000000000")
					.nome("Paulo")
					.build();
			repository.save(cliente);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MatrixApplication.class, args);
	}

}
