package com.api.barberdata.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity(name = "Servicos")
@Table(name = "SERVICOS")
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "NOME_SERVICO")
    private String servicoNome;

    @NotNull
    @Column(name = "DESCRICAO_SERVICO")
    private String descricao;

    @Positive(message = "O Valor do Serviço Não Pode Ser Negativo!")
    @Column(name = "CUSTO_SERVICO")
    private Double custo;

    @Positive(message = "O Valor do Serviço Não Pode Ser Negativo!")
    @Column(name = "VALOR_SERVICO")
    private Double servicoValor;

    @OneToMany(mappedBy = "servico" )
    @JsonIgnore
    private List<Agendamento> agendamentos;
}