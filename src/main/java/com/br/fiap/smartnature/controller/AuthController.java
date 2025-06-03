package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "123".equals(password)) {
            return jwtUtil.gerarToken(username);
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}
