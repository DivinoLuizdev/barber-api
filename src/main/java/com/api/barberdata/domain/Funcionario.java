package com.api.barberdata.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity(name = "Funcionario")
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Long id;
    
    @NotNull
    @Column(name = "LOGIN_FUNCIONARIO", unique = true)
    private String login;

    @NotNull
    @Column(name = "SENHA_FUNCIONARIO")
    private String senha;
    
    @NotNull
    @Email(message = "O email fornecido é inválido.")
    @Column(name = "EMAIL_FUNCIONARIO", unique = true)
    private String email;

    @Pattern(regexp = "^\\(\\d{2}\\) \\d{9}$",message = "O telefone fornecido é inválido.")
    @Column(name = "TELEFONE_FUNCIONARIO")
    private String fone;

    @DecimalMax(value = "100.0")
    @Column(name = "COMISSAO_FUNCIONARIO")
    private Double comissao;

    @Column(name = "SALARIO_FUNCIONARIO")
    private Double salario;

   

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Agendamento> agendamentos;

    @OneToMany(orphanRemoval = false, mappedBy = "executorServico")
    @JsonIgnore
    private List<OrdemServicos> responsavelExecutarServico;
}