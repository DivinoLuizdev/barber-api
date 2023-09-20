package com.api.barberdata.model;

import org.hibernate.validator.constraints.br.CNPJ;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "FORNECEDOR")
@Entity(name = "Fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORNECEDOR")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "NOME_FORNECEDOR")
    private String nome;

    @Size(max = 20)
    @Column(name = "TELEFONE_FORNECEDOR")
    private String telefone;

    @Email
    @Size(max = 255)
    @Column(name = "EMAIL_FORNECEDOR")
    private String email;

    @NotBlank
    @Size(max = 2)
    @Column(name = "UF_FORNECEDOR")
    private String uf;

    @CNPJ
    @Column(name = "CNPJ_FORNECEDOR")
    private String cnpj;

}
