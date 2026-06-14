package com.ecommerce.auth.service;

import com.ecommerce.auth.dto.LoginRequest;
import com.ecommerce.auth.dto.LoginResponse;
import com.ecommerce.auth.dto.RegisterRequest;
import com.ecommerce.auth.model.User;
import com.ecommerce.auth.repository.UserRepository;
import com.ecommerce.auth.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User register(RegisterRequest request) {

        User user = new User();

        user.setNome(request.getNome());
        user.setEmail(request.getEmail());

        user.setSenha(
                passwordEncoder.encode(
                        request.getSenha()));

        user.setRole("USER");

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(
            request.getEmail()
    ).orElseThrow(
            () -> new RuntimeException(
                    "Usuário não encontrado"
            )
    );

    if (!passwordEncoder.matches(
            request.getSenha(),
            user.getSenha()
    )) {

        throw new RuntimeException(
                "Senha inválida"
        );
    }

    String token =
            jwtService.generateToken(
                    user.getEmail(),
                    user.getRole()
            );

    return new LoginResponse(token);
}

}