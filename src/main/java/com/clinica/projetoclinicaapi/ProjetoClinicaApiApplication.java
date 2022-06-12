package com.clinica.projetoclinicaapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.clinica.projetoclinicaapi.model.Paciente;
import com.clinica.projetoclinicaapi.repository.PacienteRepository;

@SpringBootApplication
public class ProjetoClinicaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoClinicaApiApplication.class, args);
	}


@Bean
CommandLineRunner initDatabase(PacienteRepository pacienteRepository) {
	return args -> {
		pacienteRepository.deleteAll();

		Paciente p = new Paciente();
		p.setNome("Joao");
		p.setCpf("111111");
		p.setDtCriacao("hj");
		p.setDtNascimento("oqwooqw");
		p.setEndereco("Rua A");
		p.setTelefone("010101");

		pacienteRepository.save(p);

		
	};
}
}
