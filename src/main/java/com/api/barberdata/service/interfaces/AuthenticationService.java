package com.api.barberdata.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.api.barberdata.domain.dto.AuthenticationDTO;
import com.api.barberdata.domain.dto.LoginResponseDTO;
import com.api.barberdata.domain.dto.RegisterDTO;

import jakarta.validation.Valid;
 

public interface AuthenticationService<T> {

  
  ResponseEntity<LoginResponseDTO> login(@Valid AuthenticationDTO data);

    ResponseEntity<?> register(RegisterDTO data);
    
}
