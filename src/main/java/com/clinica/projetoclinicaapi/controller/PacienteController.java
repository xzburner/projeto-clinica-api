package com.clinica.projetoclinicaapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.projetoclinicaapi.model.Paciente;
import com.clinica.projetoclinicaapi.repository.PacienteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor

@Component
public class PacienteController {

    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> listaPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente cadastraPacientes(@RequestBody Paciente dadosPaciente) {
        return pacienteRepository.save(dadosPaciente);
    }

}
