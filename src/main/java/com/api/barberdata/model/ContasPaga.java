package com.api.barberdata.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

 
@Table(name = "CONTASPAGA")
@Entity(name = "ContasPaga")
@Data
 
public class ContasPaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTASPAGA")
    private Long id;
    
    @NotNull(message = "A data de emissão não pode ser nula.")
    @Column(name = "EMISSAO_CONTASPAGA", nullable = false)
    private Date emissao;
    
    @NotNull(message = "A data de vencimento não pode ser nula.")
    @Column(name = "VENCIMENTO_CONTASPAGA", nullable = false)
    private Date vencimento;
    
    @NotNull(message = "O valor não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor mínimo permitido é 0.01.")
    @Column(name = "VALOR_CONTASPAGA", nullable = false)
    private Double valor;
    
    @NotNull(message = "O valor pago não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor mínimo permitido é 0.01.")
    @Column(name = "VALORPAGO_CONTASPAGA", nullable = false)
    private Double valorPago;
    
    @NotNull(message = "A data de pagamento não pode ser nula.")
    @Column(name = "PAGAMENTO_CONTASPAGA", nullable = false)
    private Date pagamento;
    
    @NotNull(message = "O status não pode ser nulo.")
    @Column(name = "STATUS_CONTASPAGA", nullable = false)
    private Integer status;
    
   
 
   
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity =  com.api.barberdata.model.Fornecedor.class)
    @JoinColumn(name = " ID_FORNECEDOR_FK", referencedColumnName = "ID_FORNECEDOR", nullable = false)
    private List<Fornecedor> fornecedores;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity =  com.api.barberdata.model.Funcionario.class)
    @JoinColumn(name = " ID_FUNCIONARIO_FK", referencedColumnName = "ID_FUNCIONARIO", nullable = false)
     private List<Funcionario> funcionario ;
     

}

