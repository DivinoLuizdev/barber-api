package com.api.barberdata.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "OrdemServicos")
@Table(name = "ORDEM_SERVICOS")
public class OrdemServicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM_SERVICOS")
    private Long id;

    @Column(name = "HORARIO_INICIO_ORDEM_SERVICOS")
    private LocalDateTime dataHorarioInicio;

    @Column(name = "HORARIO_TERMINO_ORDEM_SERVICOS")
    private LocalDateTime dataHorarioTermino;

    @Column(name = "STATUS_SERVICOS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_AGENDAMENTO_FK", referencedColumnName = "ID_AGENDAMENTO", unique = true)
    @NotNull(message = "O Agendamento da Ordem de Serviço Deve Ser Informado!")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO_FK", referencedColumnName = "ID_SERVICO")
    @NotNull(message = "O Serviço da Ordem de Serviço Deve Ser Informado!")
    private Servicos servico;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_RESPONSAVEL_OS_FK", referencedColumnName = "ID_FUNCIONARIO")
    @NotNull(message = "O Reponsável Pelo Lançamento da Ordem de Serviço Deve Ser Informado!")
    private Funcionario responsavelPelaOS;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_EXECUTAR_SERVICO_FK", referencedColumnName = "ID_FUNCIONARIO")
    private Funcionario executorServico;
}