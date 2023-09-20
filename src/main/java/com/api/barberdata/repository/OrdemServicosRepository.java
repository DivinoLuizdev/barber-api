package com.api.barberdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.barberdata.domain.OrdemServicos;

 

public interface  OrdemServicosRepository extends JpaRepository< OrdemServicos, Long> {

}