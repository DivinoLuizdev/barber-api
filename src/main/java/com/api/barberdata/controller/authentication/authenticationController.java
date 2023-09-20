package com.api.barberdata.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.barberdata.domain.dto.AuthenticationDTO;
import com.api.barberdata.domain.dto.LoginResponseDTO;
import com.api.barberdata.domain.dto.RegisterDTO;
import com.api.barberdata.domain.user.User;
import com.api.barberdata.repository.UserRepository;
import com.api.barberdata.security.TokenService;

import jakarta.validation.Valid;
/**
 * Controlador responsável pelas operações de autenticação de usuários.
 */
@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class authenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    

     /**
     * Endpoint para autenticar um usuário e gerar um token JWT.
     *
     * @param data Os dados de autenticação do usuário.
     * @return ResponseEntity contendo o token JWT no corpo da resposta.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

     /**
     * Endpoint para registrar um novo usuário.
     *
     * @param data Os dados do novo usuário a serem registrados.
     * @return ResponseEntity com status de sucesso se o registro for bem-sucedido.
     */
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data){
    if(this.repository.findByLogin(data.login()) != null) return
    ResponseEntity.badRequest().build();

    String encryptedPassword = new
    BCryptPasswordEncoder().encode(data.password());
    User newUser = new User(data.login(), encryptedPassword, data.role());

    this.repository.save(newUser);

    return ResponseEntity.ok().build();
}
}