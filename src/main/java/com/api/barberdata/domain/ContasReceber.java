package com.api.barberdata.domain;
 
 
import java.math.BigDecimal;
import java.time.LocalDate;
 
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
 
import jakarta.persistence.ManyToOne;
 
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
 
import jakarta.validation.constraints.Size;
import lombok.Data;
 

 


@Data
@Entity(name = "ContasReceber")
@Table(name = "CONTASRECEBER")
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTASRECEBER")
    private Long id;

    @NotNull
    @Column(name = "EMISSAO_CONTASRECEBER")
    private LocalDate emissao;

    @NotNull
    @Column(name = "VENCIMENTO_CONTASRECEBER")
    private LocalDate vencimento;

    @DecimalMin("0.01")
    @Column(name = "VALORRECEBIDO_CONTASRECEBER")
    private BigDecimal valorRecebido;

    @Column(name = "RECEBIMENTO_CONTASRECEBER")
    private LocalDate recebimento;

    @NotNull
    @Size(max = 20)
    @Column(name = "STATUS_CONTASRECEBER")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEM_SERVICOS_FK", referencedColumnName = "ID_ORDEM_SERVICOS")
    private  OrdemServicos ordemServicos;
   
}
