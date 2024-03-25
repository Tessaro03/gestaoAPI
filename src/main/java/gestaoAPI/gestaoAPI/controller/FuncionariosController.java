package gestaoAPI.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioAlterarDTO;
import gestaoAPI.gestaoAPI.dtos.funcionario.FuncionarioInputDTO;
import gestaoAPI.gestaoAPI.service.FuncionarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionariosController {

    @Autowired
    private FuncionarioService service;


    @GetMapping
    public ResponseEntity ver(HttpServletRequest request){
        var funcionarios = service.ver(request);
        return ResponseEntity.ok().body(funcionarios);
    }

    @PostMapping
    public void criar(HttpServletRequest request, @RequestBody @Valid FuncionarioInputDTO dados){
        service.criar(dados, request);
    }

    @PatchMapping("/{id}")
    public void alterar(HttpServletRequest request,@RequestBody @Valid FuncionarioAlterarDTO dados,@PathVariable Long id){
        service.alterar(request, dados, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id, HttpServletRequest request){
        service.deletar(request, id);
    }

}