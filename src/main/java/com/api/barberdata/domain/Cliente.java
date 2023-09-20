package com.api.barberdata.domain;

import java.util.ArrayList;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
@Entity(name = "Cliente")
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "NOME_CLIENTE")
    private String nome;

    @NotBlank
    @Column(name = "TELEFONE_CLIENTE", unique = true)
    private String telefone;

 
    @Email
    @Column(name = "EMAIL_CLIENTE", unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$")
    @Column(name = "UF_CLIENTE")
    private String uf;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Agendamento> agendamentos = new ArrayList<>();
}