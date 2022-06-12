package com.clinica.projetoclinicaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column(length = 200, nullable = false)
    private String cpf;

    @Column(length = 200, nullable = true, name = "dt_criacao")
    private String dtCriacao;

    @Column(length = 200, nullable = false)
    private String telefone;

    @Column(length = 200, nullable = false, name = "dt_nascimento")
    private String dtNascimento;

    @Column(length = 200, nullable = false)
    private String endereco;
    

}


