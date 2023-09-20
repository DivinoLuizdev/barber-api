package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.barberdata.domain.Servicos;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {

}