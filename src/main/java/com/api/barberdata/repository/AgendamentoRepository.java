package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.barberdata.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}