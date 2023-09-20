package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.barberdata.domain.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}