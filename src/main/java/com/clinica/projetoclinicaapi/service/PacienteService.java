package com.clinica.projetoclinicaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.projetoclinicaapi.model.Paciente;
import com.clinica.projetoclinicaapi.repository.PacienteRepository;
import com.clinica.projetoclinicaapi.service.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

	public Paciente findById(Integer id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	public Paciente cadastraPaciente(Paciente paciente) {
		paciente.setId(null);
		return pacienteRepository.save(paciente);
	}

	public void deletaPaciente(Integer id) {
		findById(id);
		pacienteRepository.deleteById(id);		
	}

	public Paciente atualizaPaciente(Integer id, Paciente paciente) {
		Paciente novoPaciente =  findById(id);
		novoPaciente.setNome(paciente.getNome());
		novoPaciente.setCpf(paciente.getCpf());
		novoPaciente.setDtNascimento(paciente.getDtNascimento());
		novoPaciente.setEndereco(paciente.getEndereco());
		novoPaciente.setTelefone(paciente.getTelefone());
		
		return pacienteRepository.save(novoPaciente);
		
	}
}
