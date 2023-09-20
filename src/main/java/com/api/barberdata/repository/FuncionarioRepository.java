package com.api.barberdata.repository;

import com.api.barberdata.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT COUNT(f) > 0 FROM Funcionario f WHERE f.email = ?1")
    boolean existsByEmail(String email);

}