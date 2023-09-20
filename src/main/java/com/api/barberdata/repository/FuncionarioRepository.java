package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.Query;

import com.api.barberdata.domain.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT COUNT(f) > 0 FROM Funcionario f WHERE f.email = ?1")
    boolean existsByEmail(String email);

}