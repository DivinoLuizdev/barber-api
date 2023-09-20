package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.barberdata.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT COUNT(f) > 0 FROM Cliente f WHERE f.email = ?1")
    boolean existsByEmail(String email);

}
