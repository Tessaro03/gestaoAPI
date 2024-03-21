package gestaoAPI.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionariosController {

    @Autowired
    private FuncionarioService service;


    @GetMapping
    public ResponseEntity ver(){
        var funcionarios = service.ver();
        return ResponseEntity.ok().body(funcionarios);
    }

    @PostMapping
    public void criar(@RequestBody @Valid FuncionarioInputDTO dados){
        service.criar(dados);
    }
}