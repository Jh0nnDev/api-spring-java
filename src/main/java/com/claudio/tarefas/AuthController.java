package com.claudio.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario encontrado = usuarioRepository.findByEmail(usuario.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(usuario.getSenha(), encontrado.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        return jwtService.gerarToken(encontrado.getEmail());
    }
}