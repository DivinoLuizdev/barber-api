package com.api.barberdata.model;

import java.util.Date;
import com.api.barberdata.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore; 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name = "Agendamento")
@Table(name = "AGENDAMENTOS")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDAMENTO", nullable = false)
    private Long id;

    @Column(name = "DATA_AGENDAMENTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING )
    @FutureOrPresent(message = "O Agendamento Só Pode Ser Feito Para Agora ou No Futuro!")
    private Date data;

    @NotNull
    @Column(name = "HORA_AGENDAMENTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt_BR")
    @Temporal(TemporalType.TIME)
    private Date hora;

    @Column(name = "STATUS_AGENDAMENTO")
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @Column(name = "OBSERVACAO_AGENDAMENTO")
    private String observacao;

    @ManyToOne
    
    @JoinColumn(name = "ID_CLIENTE_FK", referencedColumnName = "ID_CLIENTE" )
    @NotNull(message = "O Cliente do Agendamento Deve Ser Informado!")
    private Cliente cliente;

    @ManyToOne

    @JoinColumn(name = "ID_RESPONSAVEL_AGENDAMENTO_FK", referencedColumnName = "ID_FUNCIONARIO")
    @NotNull(message = "O Responsável do Agendamento Deve Ser Informado!")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO_FK", referencedColumnName = "ID_SERVICO")
    @NotNull(message = "O Serviço do Agendamento Deve Ser Informado!")
    private Servicos servico;

    @OneToOne(mappedBy = "agendamento" ,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private OrdemServicos ordemServico;
}
