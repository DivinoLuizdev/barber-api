package com.api.barberdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.barberdata.domain.dto.LoginResponseDTO;
import com.api.barberdata.domain.user.User;
import com.api.barberdata.repository.UserRepository;
import com.api.barberdata.security.TokenService;
import com.api.barberdata.service.interfaces.AuthenticationService;

import jakarta.validation.Valid;

import com.api.barberdata.domain.dto.AuthenticationDTO;
 
import com.api.barberdata.domain.dto.RegisterDTO;
public class AuthenticationServiceImpl implements AuthenticationService<User> {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<LoginResponseDTO> login(@Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Override
    public ResponseEntity<?> register(RegisterDTO data) {
        if (userRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
