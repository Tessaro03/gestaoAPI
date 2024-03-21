package gestaoAPI.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gestaoAPI.gestaoAPI.dtos.usuario.DadosCadastroUsuario;
import gestaoAPI.gestaoAPI.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios")
    public ResponseEntity ver(){
        var usuarios = service.ver();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/cadastrar")
    public void criar(@RequestBody @Valid DadosCadastroUsuario dados){
        service.criar(dados);
    }
}
