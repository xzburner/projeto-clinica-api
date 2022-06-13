package com.clinica.projetoclinicaapi.controller;


import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.clinica.projetoclinicaapi.model.Paciente;
import com.clinica.projetoclinicaapi.repository.PacienteRepository;
import com.clinica.projetoclinicaapi.service.PacienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor

@Component
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping(value = "editar/{id}")
    public ResponseEntity<Paciente>findById(@PathVariable Integer id){
        Paciente paciente = this.pacienteService.findById(id);
        return ResponseEntity.ok().body(paciente);
        
    }
    
    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
    	List<Paciente> list = pacienteService.findAll();
    	return ResponseEntity.ok().body(list);
    	
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Paciente> cadastraPaciente(@RequestBody Paciente paciente){
    	Paciente novoPaciente = pacienteService.cadastraPaciente(paciente);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoPaciente.getId()).toUri();
    	return ResponseEntity.created(uri).build();
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaPaciente(@PathVariable Integer id){
    	pacienteService.deletaPaciente(id);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "editar/{id}")
    public ResponseEntity<Paciente> atualizaPaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
    	Paciente novoPaciente = pacienteService.atualizaPaciente(id, paciente);   
    	return ResponseEntity.ok().body(novoPaciente);
    }

}







